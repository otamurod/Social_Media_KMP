package uz.otamurod.socialmediakmp.feature.auth.data.repository

import kotlinx.coroutines.withContext
import uz.otamurod.socialmediakmp.feature.auth.data.network.api.AuthService
import uz.otamurod.socialmediakmp.feature.auth.data.network.api.entities.request.SignInRequest
import uz.otamurod.socialmediakmp.feature.auth.data.network.api.entities.request.SignUpRequest
import uz.otamurod.socialmediakmp.feature.auth.data.network.mapper.AuthResponseDataMapper
import uz.otamurod.socialmediakmp.feature.auth.domain.api.repository.AuthRepositoryApi
import uz.otamurod.socialmediakmp.feature.auth.domain.model.AuthResult
import uz.otamurod.socialmediakmp.feature.common.util.DispatcherProvider
import uz.otamurod.socialmediakmp.feature.common.util.ResultWrapper

internal class AuthRepository(
    private val dispatcher: DispatcherProvider,
    private val authService: AuthService
) : AuthRepositoryApi {
    override suspend fun signUp(
        username: String,
        email: String,
        password: String
    ): ResultWrapper<AuthResult> {
        return withContext(dispatcher.io) {
            try {
                val request = SignUpRequest(username, email, password)
                val authResponse = authService.signUp(request)

                if (authResponse.data == null) {
                    ResultWrapper.Error(message = authResponse.errorMessage!!)
                } else {
                    ResultWrapper.Success(
                        data = AuthResponseDataMapper.AuthResult(authResponse.data).invoke()
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                ResultWrapper.Error(message = "Oops, we could not send your request, try later!")
            }
        }
    }

    override suspend fun signIn(username: String, password: String): ResultWrapper<AuthResult> {
        return withContext(dispatcher.io) {
            try {
                val request = SignInRequest(username, password)
                val authResponse = authService.signIn(request)

                if (authResponse.data == null) {
                    ResultWrapper.Error(message = authResponse.errorMessage!!)
                } else {
                    ResultWrapper.Success(
                        data = AuthResponseDataMapper.AuthResult(authResponse.data).invoke()
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                ResultWrapper.Error(message = "Oops, we could not send your request, try later!")
            }
        }
    }
}