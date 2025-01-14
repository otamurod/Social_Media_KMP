package uz.otamurod.socialmediakmp.feature.auth.domain.model

data class AuthResult(
    val id: Int,
    val username: String,
    val bio: String,
    val avatar: String? = null,
    val token: String,
    val followersCount: Int = 0,
    val followingCount: Int = 0,
)