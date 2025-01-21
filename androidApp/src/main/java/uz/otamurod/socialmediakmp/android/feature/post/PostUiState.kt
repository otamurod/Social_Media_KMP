package uz.otamurod.socialmediakmp.android.feature.post

import uz.otamurod.socialmediakmp.common.domain.model.Post

data class PostUiState(
    val isLoading: Boolean = true,
    val post: Post? = null,
    val errorMessage: String? = null
)