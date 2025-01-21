package uz.otamurod.socialmediakmp.android.feature.post

import uz.otamurod.socialmediakmp.feature.post.domain.model.PostComment

data class CommentsUiState(
    val isLoading: Boolean = false,
    val comments: List<PostComment> = listOf(),
    val errorMessage: String? = null,
    val endReached: Boolean = false,
    val isAddingNewComment: Boolean = false
)