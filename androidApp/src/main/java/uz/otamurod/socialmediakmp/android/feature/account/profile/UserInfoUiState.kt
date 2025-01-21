package uz.otamurod.socialmediakmp.android.feature.account.profile

import uz.otamurod.socialmediakmp.feature.account.domain.model.Profile

data class UserInfoUiState(
    val isLoading: Boolean = true,
    val profile: Profile? = null,
    val errorMessage: String? = null
)