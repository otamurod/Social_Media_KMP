package uz.otamurod.socialmediakmp.android.feature.account.follows

import uz.otamurod.socialmediakmp.common.domain.model.FollowingUser

data class FollowsUiState(
    val isLoading: Boolean = false,
    val followsUsers: List<FollowingUser> = listOf(),
    val errorMessage: String? = null,
)