package uz.otamurod.socialmediakmp.android.feature.account.editprofile

import uz.otamurod.socialmediakmp.feature.account.domain.model.Profile

data class EditProfileUiState(
    val isLoading: Boolean = false,
    val profile: Profile? = null,
    val uploadSucceed: Boolean = false,
    val errorMessage: String? = null
)