package uz.otamurod.socialmediakmp.feature.auth.data.network.api

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import uz.otamurod.socialmediakmp.feature.auth.data.network.api.entities.request.SignInRequest
import uz.otamurod.socialmediakmp.feature.auth.data.network.api.entities.request.SignUpRequest
import uz.otamurod.socialmediakmp.feature.auth.data.network.api.entities.response.AuthResponse
import uz.otamurod.socialmediakmp.common.data.network.api.AuthApi

internal class AuthService : AuthApi() {
    suspend fun signUp(request: SignUpRequest): AuthResponse {
        return client.post {
            endPoint("signup")
            setBody(request)
        }.body()
    }

    suspend fun signIn(request: SignInRequest): AuthResponse {
        return client.post {
            endPoint("login")
            setBody(request)
        }.body()
    }
}