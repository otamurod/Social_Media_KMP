package uz.otamurod.socialmediakmp.android.feature.account.editprofile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleProfilesDummyData

class EditProfileViewModel : ViewModel() {
    var uiState: EditProfileUiState by mutableStateOf(EditProfileUiState())
        private set

    var bioTextFieldValue: TextFieldValue by mutableStateOf(TextFieldValue(text = ""))
        private set

    fun fetchProfile(userId: Long) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            delay(1000)

            uiState = uiState.copy(
                isLoading = false,
                profile = sampleProfilesDummyData.find { it.id == userId }?.toProfileBo()
            )

            bioTextFieldValue = TextFieldValue(
                text = uiState.profile?.bio ?: "",
                selection = TextRange(index = uiState.profile?.bio?.length ?: 0)
            )
        }
    }

    fun uploadProfile() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            delay(1000)

            uiState = uiState.copy(
                isLoading = false,
                uploadSucceed = true
            )
        }
    }

    fun onNameChange(name: String) {
        uiState = uiState.copy(
            profile = uiState.profile?.copy(name = name)
        )
    }

    fun onBioChange(bio: TextFieldValue) {
        bioTextFieldValue = TextFieldValue(
            text = bio.text,
            selection = TextRange(index = bio.text.length)
        )
    }
}