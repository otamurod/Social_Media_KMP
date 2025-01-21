package uz.otamurod.socialmediakmp.common.domain.model

data class FollowingUser(
    val id: Long,
    val name: String,
    val bio: String,
    val imageUrl: String? = null,
    val isFollowing: Boolean
)