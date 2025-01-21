package uz.otamurod.socialmediakmp.feature.auth.domain.api.repository

import uz.otamurod.socialmediakmp.feature.auth.domain.model.AuthResult
import uz.otamurod.socialmediakmp.common.util.ResultWrapper

internal interface AuthRepositoryApi {
    suspend fun signUp(
        username: String,
        email: String,
        password: String
    ): ResultWrapper<AuthResult>

    suspend fun signIn(
        username: String,
        password: String
    ): ResultWrapper<AuthResult>
}