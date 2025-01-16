package uz.otamurod.socialmediakmp.android.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.theming.DarkGray
import uz.otamurod.socialmediakmp.android.common.theming.LightGray
import uz.otamurod.socialmediakmp.android.common.theming.MediumSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme

@Composable
fun PostLikesRow(
    modifier: Modifier = Modifier,
    likesCount: Int,
    commentCount: Int,
    onLikeClick: () -> Unit,
    isPostLiked: Boolean,
    onCommentClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 0.dp,
                horizontal = MediumSpacing
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onLikeClick
        ) {
            Icon(
                painter = if (isPostLiked) {
                    painterResource(id = R.drawable.like_icon_filled)
                } else {
                    painterResource(id = R.drawable.like_icon_outlined)
                },
                contentDescription = null,
                tint = if (isPostLiked) Red else DarkGray
            )
        }

        Text(
            text = "$likesCount",
            style = MaterialTheme.typography.subtitle2.copy(fontSize = 18.sp)
        )

        Spacer(modifier = modifier.width(MediumSpacing))

        IconButton(
            onClick = onCommentClick
        ) {
            Icon(
                painter = painterResource(id = R.drawable.chat_icon_outlined),
                contentDescription = null,
                tint = if (MaterialTheme.colors.isLight) {
                    LightGray
                } else {
                    DarkGray
                }
            )
        }

        Text(
            text = "$commentCount",
            style = MaterialTheme.typography.subtitle2.copy(fontSize = 18.sp)
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PostLikesRowPreview() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.surface) {
            PostLikesRow(
                likesCount = 12,
                commentCount = 2,
                onLikeClick = {},
                isPostLiked = true,
                onCommentClick = {}
            )
        }
    }
}