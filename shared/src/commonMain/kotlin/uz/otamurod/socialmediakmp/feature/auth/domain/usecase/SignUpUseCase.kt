package uz.otamurod.socialmediakmp.feature.auth.domain.usecase

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uz.otamurod.socialmediakmp.feature.auth.domain.api.repository.AuthRepositoryApi
import uz.otamurod.socialmediakmp.feature.auth.domain.model.AuthResult
import uz.otamurod.socialmediakmp.feature.common.util.ResultWrapper

class SignUpUseCase : KoinComponent {
    private val authRepository: AuthRepositoryApi by inject()

    suspend operator fun invoke(
        username: String,
        email: String,
        password: String
    ): ResultWrapper<AuthResult> {
        if (username.isBlank() || username.length < 3) {
            return ResultWrapper.Error(message = "Username must be at least 3 characters!")
        }

        if (email.isBlank() || !email.contains("@")) {
            return ResultWrapper.Error(message = "Email is not valid!")
        }

        if (password.isBlank() || password.length < 4) {
            return ResultWrapper.Error(message = "Password must be at least 4 characters!")
        }

        return authRepository.signUp(username, email, password)
    }
}