package uz.otamurod.socialmediakmp.android.feature.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.components.CommentListItem
import uz.otamurod.socialmediakmp.android.common.components.PostListItem
import uz.otamurod.socialmediakmp.android.common.dummy_data.sampleCommentsDummyData
import uz.otamurod.socialmediakmp.android.common.dummy_data.samplePostsDummyData
import uz.otamurod.socialmediakmp.android.common.theming.ExtraLargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.android.feature.post.components.CommentsHeaderSection
import uz.otamurod.socialmediakmp.feature.post.domain.model.PostComment

@Composable
fun PostDetailScreen(
    modifier: Modifier = Modifier,
    postUiState: PostUiState,
    commentsUiState: CommentsUiState,
    onCommentMoreIconClick: (PostComment) -> Unit,
    onProfileClick: (Long) -> Unit,
    onAddCommentClick: () -> Unit,
    fetchData: () -> Unit
) {
    if (postUiState.isLoading && commentsUiState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (postUiState.post != null) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.surface)
        ) {
            item(key = "post_item") {
                PostListItem(
                    post = postUiState.post,
                    onPostClick = {},
                    onProfileClick = onProfileClick,
                    onLikeClick = {},
                    onCommentClick = {},
                )
            }

            item(key = "comments_header_section") {
                CommentsHeaderSection(
                    onAddCommentClick = onAddCommentClick
                )
            }

            items(
                items = commentsUiState.comments,
                key = { comment -> comment.commentId }
            ) { postComment ->
                Divider()

                CommentListItem(
                    comment = postComment,
                    onProfileClick = onProfileClick,
                ) {
                    onCommentMoreIconClick(it)
                }
            }
        }
    } else {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(LargeSpacing)
            ) {
                Text(
                    text = stringResource(id = R.string.loading_error_message),
                    style = MaterialTheme.typography.caption
                )

                OutlinedButton(
                    onClick = fetchData,
                    shape = RoundedCornerShape(percent = 50),
                    contentPadding = PaddingValues(horizontal = ExtraLargeSpacing)
                ) {
                    Text(text = stringResource(id = R.string.retry_button_text))
                }
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        fetchData()
    }
}

@Preview(name = "PostDetailScreen")
@Composable
private fun PreviewPostDetailScreen() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            PostDetailScreen(
                postUiState = PostUiState(
                    isLoading = false,
                    post = samplePostsDummyData.first().toPostBo()
                ),
                commentsUiState = CommentsUiState(
                    isLoading = false,
                    comments = sampleCommentsDummyData.map { it.toCommentBo() }
                ),
                onCommentMoreIconClick = {},
                onProfileClick = {},
                onAddCommentClick = {},
                fetchData = {}
            )
        }
    }
}