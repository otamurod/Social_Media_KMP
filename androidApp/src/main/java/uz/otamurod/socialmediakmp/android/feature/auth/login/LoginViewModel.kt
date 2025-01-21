package uz.otamurod.socialmediakmp.android.feature.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.otamurod.socialmediakmp.android.common.data.datastore.UserSettings
import uz.otamurod.socialmediakmp.android.common.data.datastore.mapper.AuthResultMapper
import uz.otamurod.socialmediakmp.feature.auth.domain.usecase.SignInUseCase
import uz.otamurod.socialmediakmp.common.util.ResultWrapper

class LoginViewModel(
    private val singInUseCase: SignInUseCase,
    private val dataStore: DataStore<UserSettings>
) : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun signIn() {
        viewModelScope.launch {
            uiState = uiState.copy(isAuthenticating = true)

            val authResult = singInUseCase.invoke(uiState.email, uiState.password)

            uiState = when (authResult) {
                is ResultWrapper.Success -> {
                    dataStore.updateData {
                        AuthResultMapper.UserSettings(authResult.data!!).invoke()
                    }

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

    fun updateEmail(input: String) {
        uiState = uiState.copy(email = input)
    }

    fun updatePassword(input: String) {
        uiState = uiState.copy(password = input)
    }
}

data class LoginUiState(
    var email: String = "",
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var isAuthSucceed: Boolean = false
)