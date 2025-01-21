package uz.otamurod.socialmediakmp.android.feature.post.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme

@Composable
fun CommentsHeaderSection(
    modifier: Modifier = Modifier,
    onAddCommentClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = LargeSpacing),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.comments_label),
            style = MaterialTheme.typography.subtitle1,
            modifier = modifier.weight(1f)
        )

        OutlinedButton(
            onClick = onAddCommentClick
        ) {
            Text(
                text = stringResource(id = R.string.add_comment_button_label),
                style = MaterialTheme.typography.button
            )
        }
    }
}

@Preview(name = "CommentsHeaderSection")
@Composable
private fun PreviewCommentsHeaderSection() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            CommentsHeaderSection(
                onAddCommentClick = {}
            )
        }
    }
}