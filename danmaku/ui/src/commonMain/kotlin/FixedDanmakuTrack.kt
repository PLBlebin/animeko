/*
 * Copyright (C) 2024-2025 OpenAni and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license, which can be found at the following link.
 *
 * https://github.com/open-ani/ani/blob/main/LICENSE
 */

package me.him188.ani.danmaku.ui

import androidx.compose.runtime.IntState
import androidx.compose.runtime.LongState
import androidx.compose.runtime.Stable

/**
 * FixedDanmakuTrack 中的弹幕在以下情况会移除:
 * - tick 中的逻辑帧检测
 * - [FixedDanmakuTrack.place] 覆盖了正在显示的弹幕
 * - 调用 [DanmakuTrack.clearAll]
 */
@Stable
internal class FixedDanmakuTrack<T : SizeSpecifiedDanmaku>(
    val trackIndex: Int,
    val fromBottom: Boolean,
    private val frameTimeNanosState: LongState,
    private val trackHeight: IntState,
    private val hostHeight: IntState,
    // 顶部或底部弹幕的显示时间，现在还不能自定义
    private val durationMillis: LongState,
) : DanmakuTrack<T, FixedDanmaku<T>> {
    internal var currentDanmaku: FixedDanmaku<T>? = null
        private set
    internal var pendingDanmaku: T? = null
        private set

    override fun place(danmaku: T, placeFrameTimeNanos: Long): FixedDanmaku<T> {
        check(placeFrameTimeNanos == DanmakuTrack.NOT_PLACED || placeFrameTimeNanos >= 0) {
            "Expected placeTimeNanos to be NOT_PLACED or non-negative, but got $placeFrameTimeNanos"
        }
        val upcomingDanmaku =
            FixedDanmaku(danmaku, placeFrameTimeNanos, trackIndex, trackHeight, hostHeight, fromBottom)
        currentDanmaku = upcomingDanmaku
        return upcomingDanmaku
    }

    override fun canPlace(
        danmaku: T,
        placeFrameTimeNanos: Long
    ): Boolean {
        check(placeFrameTimeNanos == DanmakuTrack.NOT_PLACED || placeFrameTimeNanos >= 0) {
            "Expected placeTimeNanos to be NOT_PLACED or non-negative, but had $placeFrameTimeNanos"
        }
        // 当前如果有正在显示的弹幕或者有等待显示的弹幕则一定不可发送
        if (currentDanmaku != null || pendingDanmaku != null) return false
        // 未放置的弹幕一定可以放置
        if (placeFrameTimeNanos == DanmakuTrack.NOT_PLACED) return true
        // 当前没有正在显示的弹幕并且弹幕可以被显示
        return frameTimeNanosState.longValue - placeFrameTimeNanos < durationMillis.longValue
    }

    /**
     * 设置待发送的弹幕. 当前弹幕显示完后一定显示这条弹幕.
     *
     * 如果已经有 pending, 那已有 pending 会立刻替换 current 并返回被放置的 pending
     */
    internal fun setPending(danmaku: T): FixedDanmaku<T>? {
        val lastPending = pendingDanmaku?.let { place(it) }
        pendingDanmaku = danmaku
        return lastPending
    }

    override fun clearAll() {
        currentDanmaku = null
    }

    override fun tick() {
        val current = currentDanmaku ?: return
        val danmakuTime = current.placeFrameTimeNanos
        if (frameTimeNanosState.longValue - danmakuTime >= durationMillis.longValue * 1_000_000) {
            currentDanmaku = null

            val pending = pendingDanmaku
            if (pending != null) {
                pendingDanmaku = null
            }
        }
    }

    /**
     * 这个迭代器不是线程安全的, 访问迭代器时不保证 danmakuList.
     */
    override fun iterator(): Iterator<FixedDanmaku<T>> {
        return object : Iterator<FixedDanmaku<T>> {
            private var hasNext = currentDanmaku != null

            override fun hasNext(): Boolean {
                return hasNext
            }

            override fun next(): FixedDanmaku<T> {
                if (!hasNext) throw NoSuchElementException()
                val current = currentDanmaku ?: throw NoSuchElementException()
                hasNext = false
                return current
            }
        }
    }

    override fun toString(): String {
        return "FixedTrack(index=${trackIndex}, " +
                "placeTime=${currentDanmaku?.placeFrameTimeNanos?.div(1_000_000)})"
    }
}

@Stable
internal class FixedDanmaku<T : SizeSpecifiedDanmaku>(
    var danmaku: T,
    var placeFrameTimeNanos: Long,
    internal val trackIndex: Int,
    private val trackHeight: IntState,
    private val hostHeight: IntState,
    internal val fromBottom: Boolean,
) {
    /**
     * calculate pos y lazily in ui loop
     */
    var y: Float = Float.NaN
        internal set

    internal fun calculatePosY(): Float {
        return if (fromBottom) {
            hostHeight.intValue - (trackIndex + 1) * trackHeight.intValue.toFloat()
        } else {
            trackIndex * trackHeight.intValue.toFloat()
        }
    }

    override fun toString(): String {
        return "FixedDanmaku(width=${danmaku.danmakuWidth}, y=$y)"
    }
}