package uz.otamurod.socialmediakmp.android.feature.account.follows

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleUsersDummyData

class FollowsViewModel : ViewModel() {
    var uiState by mutableStateOf(FollowsUiState())
        private set

    fun fetchFollows(userId: Long, followsType: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            delay(1000)

            uiState = uiState.copy(
                isLoading = false,
                followsUsers = sampleUsersDummyData.map {
                    it.toFollowingUser()
                }.filter { it.id != userId },
            )
        }
    }
}