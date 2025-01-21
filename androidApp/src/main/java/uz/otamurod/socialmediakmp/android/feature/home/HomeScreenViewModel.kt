package uz.otamurod.socialmediakmp.android.feature.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.otamurod.socialmediakmp.android.common.data.dummydata.samplePostsDummyData
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleUsersDummyData
import uz.otamurod.socialmediakmp.android.feature.home.onboarding.OnBoardingUiState

class HomeScreenViewModel : ViewModel() {
    var onBoardingUiState by mutableStateOf(OnBoardingUiState())
        private set

    var postsFeedUiState by mutableStateOf(PostsFeedUiState())
        private set

    var homeRefreshState by mutableStateOf(HomeRefreshState())
        private set

    init {
        fetchData()
    }

    private fun fetchData() {
        onBoardingUiState = onBoardingUiState.copy(isLoading = true)
        postsFeedUiState = postsFeedUiState.copy(isLoading = true)

        viewModelScope.launch {
            delay(1_000)

            onBoardingUiState = onBoardingUiState.copy(
                isLoading = false,
                users = sampleUsersDummyData.map { it.toFollowingUser() },
                shouldShowOnBoarding = true
            )

            postsFeedUiState = postsFeedUiState.copy(
                isLoading = false,
                posts = samplePostsDummyData.map { it.toPostBo() }
            )
        }
    }
}