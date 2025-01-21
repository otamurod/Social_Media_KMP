package uz.otamurod.socialmediakmp.android.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.data.dummydata.samplePostsDummyData
import uz.otamurod.socialmediakmp.android.common.theming.ExtraLargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.common.domain.model.Post
import uz.otamurod.socialmediakmp.common.util.toCurrentUrl

@Composable
fun PostListItem(
    modifier: Modifier = Modifier,
    post: Post,
    onPostClick: ((Post) -> Unit)? = null,
    onProfileClick: (userId: Long) -> Unit,
    onLikeClick: (Post) -> Unit,
    onCommentClick: (Post) -> Unit,
    maxLines: Int = Int.MAX_VALUE
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface)
            .let { mod ->
                if (onPostClick != null) {
                    mod
                        .clickable { onPostClick(post) }
                        .padding(bottom = ExtraLargeSpacing)
                } else {
                    mod
                }
            }
    ) {
        PostHeader(
            name = post.userName,
            profileUrl = post.userImageUrl,
            date = post.createdAt,
            onProfileClick = {
                onProfileClick(
                    post.userId
                )
            }
        )

        AsyncImage(
            model = post.imageUrl.toCurrentUrl(),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1.0f),
            contentScale = ContentScale.Crop,
            placeholder = if (MaterialTheme.colors.isLight) {
                painterResource(id = R.drawable.light_image_place_holder)
            } else {
                painterResource(id = R.drawable.dark_image_place_holder)
            }
        )

        PostLikesRow(
            likesCount = post.likesCount,
            commentCount = post.commentsCount,
            onLikeClick = { onLikeClick(post) },
            isPostLiked = post.isLiked,
            onCommentClick = { onCommentClick(post) }
        )

        Text(
            text = post.caption,
            style = MaterialTheme.typography.body2,
            modifier = modifier.padding(horizontal = LargeSpacing),
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PostListItemPreview() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.surface) {
            PostListItem(
                post = samplePostsDummyData.first().toPostBo(),
                onPostClick = {},
                onProfileClick = {},
                onCommentClick = {},
                onLikeClick = {}
            )
        }
    }
}