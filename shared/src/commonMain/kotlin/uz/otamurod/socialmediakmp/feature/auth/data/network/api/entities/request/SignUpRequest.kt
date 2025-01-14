package uz.otamurod.socialmediakmp.feature.auth.data.network.api.entities.request

import kotlinx.serialization.Serializable

@Serializable
internal data class SignUpRequest(
    val username: String,
    val email: String,
    val password: String
)

@Serializable
internal data class SignInRequest(
    val email: String,
    val password: String
)