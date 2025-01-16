package uz.otamurod.socialmediakmp.feature.common.domain.model

data class FollowingUser(
    val id: Long,
    val name: String,
    val bio: String,
    val imageUrl: String? = null,
    val isFollowing: Boolean
)