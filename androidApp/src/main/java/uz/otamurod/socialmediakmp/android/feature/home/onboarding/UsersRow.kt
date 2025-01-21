package uz.otamurod.socialmediakmp.android.feature.home.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleUsersDummyData
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.common.domain.model.FollowingUser

@Composable
fun UsersRow(
    modifier: Modifier = Modifier,
    users: List<FollowingUser>,
    onUserClick: (FollowingUser) -> Unit,
    onFollowButtonClick: (Boolean, FollowingUser) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(LargeSpacing),
        contentPadding = PaddingValues(horizontal = LargeSpacing),
        modifier = modifier
    ) {
        items(items = users, key = { user -> user.id }) {
            OnBoardingUserItem(
                followingUser = it,
                onUserClick = onUserClick,
                onFollowButtonClick = onFollowButtonClick
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun UsersRowPreview() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            UsersRow(
                users = sampleUsersDummyData.map { it.toFollowingUser() },
                onUserClick = {},
                onFollowButtonClick = { _, _ -> },
                modifier = Modifier.padding(vertical = LargeSpacing)
            )
        }
    }
}