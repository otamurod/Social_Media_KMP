package uz.otamurod.socialmediakmp.android.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.dummy_data.sampleCommentsDummyData
import uz.otamurod.socialmediakmp.android.common.theming.DarkGray
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.LightGray
import uz.otamurod.socialmediakmp.android.common.theming.MediumSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.feature.common.util.toCurrentUrl
import uz.otamurod.socialmediakmp.feature.post.domain.model.PostComment

@Composable
fun CommentListItem(
    modifier: Modifier = Modifier,
    comment: PostComment,
    onProfileClick: (Long) -> Unit,
    onMoreIconClick: (PostComment) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { }
            .padding(all = LargeSpacing),
        horizontalArrangement = Arrangement.spacedBy(MediumSpacing)
    ) {
        CircleImage(
            modifier = modifier.size(30.dp),
            url = comment.userImageUrl?.toCurrentUrl(),
            onClick = { onProfileClick(comment.userId) }
        )

        Column(
            modifier = modifier
                .weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(MediumSpacing)
            ) {
                Text(
                    text = comment.userName,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = modifier.alignByBaseline()
                )

                Text(
                    text = comment.createdAt,
                    style = MaterialTheme.typography.caption.copy(fontSize = 11.sp),
                    color = if (MaterialTheme.colors.isLight) {
                        LightGray
                    } else {
                        DarkGray
                    },
                    modifier = modifier
                        .alignByBaseline()
                        .weight(1f)
                )

                Icon(
                    painter = painterResource(id = R.drawable.round_more_horizontal),
                    contentDescription = null,
                    tint = if (MaterialTheme.colors.isLight) {
                        LightGray
                    } else {
                        DarkGray
                    },
                    modifier = modifier.clickable { onMoreIconClick(comment) }
                )
            }

            Text(
                text = comment.content,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CommentListItemPreview() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.surface) {
            CommentListItem(
                comment = sampleCommentsDummyData.first().toCommentBo(),
                onProfileClick = {},
                onMoreIconClick = {}
            )
        }
    }
}