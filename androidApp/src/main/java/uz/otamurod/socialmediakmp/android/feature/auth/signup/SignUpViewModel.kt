package uz.otamurod.socialmediakmp.android.feature.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel() : ViewModel() {
    var uiState by mutableStateOf(SignUpUiState())
        private set

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
)