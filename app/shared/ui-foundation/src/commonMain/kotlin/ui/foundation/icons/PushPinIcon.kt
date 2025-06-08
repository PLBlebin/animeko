/*
 * Copyright (C) 2024-2025 OpenAni and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license, which can be found at the following link.
 *
 * https://github.com/open-ani/ani/blob/main/LICENSE
 */

package me.him188.ani.app.ui.foundation.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val AniIcons.PushPinOn: ImageVector
    get() {
        if (_pushPinOn != null) {
            return _pushPinOn!!
        }
        _pushPinOn = ImageVector.Builder(
            name = "PushPinOn",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f,
        ).apply {
            path(
                fill = SolidColor(Color.White),
                pathFillType = PathFillType.NonZero,
            ) {
                moveTo(878.3f, 392.1f)
                lineTo(631.9f, 145.7f)
                curveToRelative(-6.5f, -6.5f, -15.0f, -9.7f, -23.5f, -9.7f)
                reflectiveCurveToRelative(-17.0f, 3.2f, -23.5f, 9.7f)
                lineTo(423.8f, 306.9f)
                curveToRelative(-12.2f, -1.4f, -24.5f, -2.0f, -36.8f, -2.0f)
                curveToRelative(-73.2f, 0.0f, -146.4f, 24.1f, -206.5f, 72.3f)
                curveToRelative(-15.4f, 12.3f, -16.6f, 35.4f, -2.7f, 49.4f)
                lineToRelative(181.7f, 181.7f)
                lineToRelative(-215.4f, 215.2f)
                curveToRelative(-2.6f, 2.6f, -4.3f, 6.1f, -4.6f, 9.8f)
                lineToRelative(-3.4f, 37.2f)
                curveToRelative(-0.9f, 9.4f, 6.6f, 17.4f, 15.9f, 17.4f)
                curveToRelative(0.5f, 0.0f, 1.0f, 0.0f, 1.5f, -0.1f)
                lineToRelative(37.2f, -3.4f)
                curveToRelative(3.7f, -0.3f, 7.2f, -2.0f, 9.8f, -4.6f)
                lineToRelative(215.4f, -215.4f)
                lineToRelative(181.7f, 181.7f)
                curveToRelative(6.5f, 6.5f, 15.0f, 9.7f, 23.5f, 9.7f)
                curveToRelative(9.7f, 0.0f, 19.3f, -4.2f, 25.9f, -12.4f)
                curveToRelative(56.3f, -70.3f, 79.7f, -158.3f, 70.2f, -243.4f)
                lineToRelative(161.1f, -161.1f)
                curveToRelative(12.9f, -12.8f, 12.9f, -33.8f, 0.0f, -46.8f)
                close()
            }
        }.build()
        return _pushPinOn!!
    }

private var _pushPinOn: ImageVector? = null


val AniIcons.PushPinOff: ImageVector
    get() {
        if (_pushPinOff != null) {
            return _pushPinOff!!
        }
        _pushPinOff = ImageVector.Builder(
            name = "PushPinOff",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f
        ).apply {
            path(
                fill = SolidColor(Color.White),
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(878.3f, 392.1f)
                lineTo(631.9f, 145.7f)
                curveToRelative(-6.5f, -6.5f, -15.0f, -9.7f, -23.5f, -9.7f)
                reflectiveCurveToRelative(-17.0f, 3.2f, -23.5f, 9.7f) // s 命令
                lineTo(423.8f, 306.9f)
                curveToRelative(-12.2f, -1.4f, -24.5f, -2.0f, -36.8f, -2.0f)
                curveToRelative(-73.2f, 0.0f, -146.4f, 24.1f, -206.5f, 72.3f)
                curveToRelative(-15.4f, 12.3f, -16.7f, 35.4f, -2.7f, 49.4f)
                lineToRelative(181.7f, 181.7f)
                lineToRelative(-215.4f, 215.2f)
                curveToRelative(-2.6f, 2.6f, -4.3f, 6.1f, -4.6f, 9.8f)
                lineToRelative(-3.4f, 37.2f)
                curveToRelative(-0.9f, 9.4f, 6.6f, 17.4f, 15.9f, 17.4f)
                curveToRelative(0.5f, 0.0f, 1.0f, 0.0f, 1.5f, -0.1f)
                lineToRelative(37.2f, -3.4f)
                curveToRelative(3.7f, -0.3f, 7.2f, -2.0f, 9.8f, -4.6f)
                lineToRelative(215.4f, -215.4f)
                lineToRelative(181.7f, 181.7f)
                curveToRelative(6.5f, 6.5f, 15.0f, 9.7f, 23.5f, 9.7f)
                curveToRelative(9.7f, 0.0f, 19.3f, -4.2f, 25.9f, -12.4f)
                curveToRelative(56.3f, -70.3f, 79.7f, -158.3f, 70.2f, -243.4f)
                lineToRelative(161.1f, -161.1f)
                curveToRelative(12.9f, -12.8f, 12.9f, -33.8f, 0.0f, -46.8f)
                close()

                moveTo(666.2f, 549.3f)
                lineToRelative(-24.5f, 24.5f)
                lineToRelative(3.8f, 34.4f)
                curveToRelative(3.7f, 33.7f, 1.0f, 67.2f, -8.2f, 99.7f)
                curveToRelative(-5.4f, 19.0f, -12.8f, 37.1f, -22.2f, 54.2f)
                lineTo(262.0f, 408.8f)
                curveToRelative(12.9f, -7.1f, 26.3f, -13.1f, 40.3f, -17.9f)
                curveToRelative(27.2f, -9.4f, 55.7f, -14.1f, 84.7f, -14.1f)
                curveToRelative(9.6f, 0.0f, 19.3f, 0.5f, 28.9f, 1.6f)
                lineToRelative(34.4f, 3.8f)
                lineToRelative(24.5f, -24.5f)
                lineTo(608.5f, 224.0f)
                lineTo(800.0f, 415.5f)
                lineTo(666.2f, 549.3f)
                close()
            }
        }.build()
        return _pushPinOff!!
    }

private var _pushPinOff: ImageVector? = null