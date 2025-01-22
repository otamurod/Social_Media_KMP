package uz.otamurod.socialmediakmp.android.feature.account.editprofile

import android.net.Uri

sealed interface EditProfileUiAction {
    data class FetchProfileAction(val userId: Long) : EditProfileUiAction
    class UploadProfileAction(val imageUri: Uri = Uri.EMPTY) : EditProfileUiAction
}