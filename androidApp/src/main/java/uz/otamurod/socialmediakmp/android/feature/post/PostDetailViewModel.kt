package uz.otamurod.socialmediakmp.android.feature.post

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.otamurod.socialmediakmp.android.common.dummy_data.sampleCommentsDummyData
import uz.otamurod.socialmediakmp.android.common.dummy_data.samplePostsDummyData

class PostDetailViewModel() : ViewModel() {
    var postUiState by mutableStateOf(PostUiState())
        private set

    var commentsUiState by mutableStateOf(CommentsUiState())
        private set

    fun fetchData(postId: Long) {
        viewModelScope.launch {
            postUiState = postUiState.copy(isLoading = true)
            commentsUiState = commentsUiState.copy(isLoading = true)

            delay(500)

            postUiState = postUiState.copy(
                isLoading = false,
                post = samplePostsDummyData.find { it.id == postId }?.toPostBo()
            )

            commentsUiState = commentsUiState.copy(
                isLoading = false,
                comments = sampleCommentsDummyData.map { it.toCommentBo() }
            )
        }
    }
}