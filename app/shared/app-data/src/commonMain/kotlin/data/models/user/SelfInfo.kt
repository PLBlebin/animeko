package me.him188.ani.app.data.models.user

import kotlinx.serialization.Serializable
import kotlin.uuid.Uuid

/**
 * @since 5.0
 */
@Serializable
data class SelfInfo(
    val id: Uuid,
    val nickname: String,
    val email: String?,
    val hasPassword: Boolean,
    val avatarUrl: String?,
)

val TestSelfInfo
    get() = SelfInfo(
        id = Uuid.random(),
        nickname = "TestUser",
        email = "test@animeko.org",
        hasPassword = false,
        avatarUrl = null,
    )
