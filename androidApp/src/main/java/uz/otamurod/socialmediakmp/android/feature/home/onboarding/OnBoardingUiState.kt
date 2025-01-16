package uz.otamurod.socialmediakmp.android.feature.home.onboarding

import uz.otamurod.socialmediakmp.feature.common.domain.model.FollowingUser

data class OnBoardingUiState2(
    val shouldShowOnBoarding: Boolean = false,
    val followableUsers: List<FollowingUser> = listOf()
)

data class OnBoardingUiState(
    val isLoading: Boolean = false,
    val users: List<FollowingUser> = listOf(),
    val errorMessage: String? = null,
    val shouldShowOnBoarding: Boolean = false
)