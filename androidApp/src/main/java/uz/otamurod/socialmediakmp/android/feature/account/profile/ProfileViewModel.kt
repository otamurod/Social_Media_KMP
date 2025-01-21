package uz.otamurod.socialmediakmp.android.feature.account.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.otamurod.socialmediakmp.android.common.data.dummydata.samplePostsDummyData
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleProfilesDummyData

class ProfileViewModel : ViewModel() {
    var userInfoUiState by mutableStateOf(UserInfoUiState())
        private set

    var profilePostsUiState by mutableStateOf(ProfilePostsUiState())
        private set

    fun fetchProfile(userId: Long) {
        viewModelScope.launch {
            userInfoUiState = userInfoUiState.copy(
                isLoading = true
            )

            delay(1000)

            userInfoUiState = userInfoUiState.copy(
                isLoading = false,
                profile = sampleProfilesDummyData.first { it.id == userId }.toProfileBo()
            )

            profilePostsUiState = profilePostsUiState.copy(
                isLoading = false,
                posts = samplePostsDummyData.map { it.toPostBo() }
            )
        }
    }
}