package uz.otamurod.socialmediakmp.android.feature.account.profile

import uz.otamurod.socialmediakmp.common.domain.model.Post

data class ProfilePostsUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = listOf(),
    val errorMessage: String? = null,
    val endReached: Boolean = false
)