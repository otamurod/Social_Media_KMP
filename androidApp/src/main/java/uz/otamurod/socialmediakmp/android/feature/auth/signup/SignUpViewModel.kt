package uz.otamurod.socialmediakmp.android.feature.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.otamurod.socialmediakmp.feature.auth.domain.usecase.SignUpUseCase
import uz.otamurod.socialmediakmp.feature.common.util.ResultWrapper

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    var uiState by mutableStateOf(SignUpUiState())
        private set

    fun signUp() {
        viewModelScope.launch {
            uiState = uiState.copy(isAuthenticating = true)

            val authResult = signUpUseCase.invoke(uiState.username, uiState.email, uiState.password)
            uiState = when (authResult) {
                is ResultWrapper.Success -> {
                    uiState.copy(
                        isAuthenticating = false,
                        isAuthSucceed = true
                    )
                }

                is ResultWrapper.Error -> {
                    uiState.copy(
                        isAuthenticating = false,
                        authErrorMessage = authResult.message
                    )
                }
            }
        }
    }

    fun updateUsername(username: String) {
        uiState = uiState.copy(username = username)
    }

    fun updateEmail(email: String) {
        uiState = uiState.copy(email = email)
    }

    fun updatePassword(password: String) {
        uiState = uiState.copy(password = password)
    }
}

data class SignUpUiState(
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var isAuthSucceed: Boolean = false
)