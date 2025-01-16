package uz.otamurod.socialmediakmp.android.feature.home.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.components.CircleImage
import uz.otamurod.socialmediakmp.android.common.components.FollowButton
import uz.otamurod.socialmediakmp.android.common.dummy_data.sampleUsersDummyData
import uz.otamurod.socialmediakmp.android.common.theming.MediumSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SmallSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.feature.common.domain.model.FollowingUser
import uz.otamurod.socialmediakmp.feature.common.util.toCurrentUrl

@Composable
fun OnBoardingUserItem(
    modifier: Modifier = Modifier,
    followingUser: FollowingUser,
    onUserClick: (FollowingUser) -> Unit,
    isFollowing: Boolean = false,
    onFollowButtonClick: (Boolean, FollowingUser) -> Unit
) {
    Card(
        modifier = modifier
            .size(height = 140.dp, width = 130.dp)
            .clickable {
                onUserClick(followingUser)
            },
        elevation = 0.dp
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(MediumSpacing),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleImage(
                modifier = modifier.size(50.dp),
                url = followingUser.imageUrl?.toCurrentUrl(),
                onClick = {}
            )

            Spacer(modifier = modifier.height(SmallSpacing))

            Text(
                text = followingUser.name,
                style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Medium),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = modifier.height(MediumSpacing))

            FollowButton(
                text = if (!followingUser.isFollowing) {
                    R.string.follow_text_label
                } else R.string.unfollow_text_label,
                onClick = { onFollowButtonClick(!isFollowing, followingUser) },
                modifier = modifier
                    .heightIn(30.dp)
                    .widthIn(100.dp),
                isOutline = followingUser.isFollowing
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingUserPreview() {
    SocialAppTheme {
        OnBoardingUserItem(
            followingUser = sampleUsersDummyData.first().toFollowingUser(),
            onUserClick = {},
            onFollowButtonClick = { _, _ -> })
    }
}