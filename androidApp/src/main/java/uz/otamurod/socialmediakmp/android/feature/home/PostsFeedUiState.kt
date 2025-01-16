package uz.otamurod.socialmediakmp.android.feature.home

import uz.otamurod.socialmediakmp.feature.common.domain.model.Post

data class PostsFeedUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = listOf(),
    val loadingErrorMessage: String? = null,
    val endReached: Boolean = false
)