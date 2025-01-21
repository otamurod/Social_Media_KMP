package uz.otamurod.socialmediakmp.android.common.data.datastore

import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val id: Int = -1,
    val username: String = "",
    val bio: String = "",
    val avatar: String? = null,
    val token: String = "",
    val followersCount: Int = 0,
    val followingCount: Int = 0,
)