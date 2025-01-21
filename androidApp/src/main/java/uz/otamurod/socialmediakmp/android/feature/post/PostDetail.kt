package uz.otamurod.socialmediakmp.android.feature.post

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun PostDetail(
    navigator: DestinationsNavigator,
    postId: Long
) {
    val viewModel: PostDetailViewModel = koinViewModel()

    PostDetailScreen(
        postUiState = viewModel.postUiState,
        commentsUiState = viewModel.commentsUiState,
        onCommentMoreIconClick = {},
        onProfileClick = {},
        onAddCommentClick = {},
        fetchData = { viewModel.fetchData(postId) }
    )
}