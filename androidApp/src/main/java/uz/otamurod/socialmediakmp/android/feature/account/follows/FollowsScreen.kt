package uz.otamurod.socialmediakmp.android.feature.account.follows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleUsersDummyData
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.android.feature.account.follows.components.FollowsListItem

@Composable
fun FollowsScreen(
    modifier: Modifier = Modifier,
    uiState: FollowsUiState,
    fetchFollows: () -> Unit,
    onItemClick: (Long) -> Unit
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
        ) {
            items(items = uiState.followsUsers, key = { user -> user.id }) {
                FollowsListItem(
                    name = it.name,
                    bio = it.bio,
                    imageUrl = it.imageUrl
                ) {
                    onItemClick(it.id)
                }
            }
        }

        if (uiState.isLoading && uiState.followsUsers.isEmpty()) {
            CircularProgressIndicator()
        }
    }

    LaunchedEffect(key1 = Unit) {
        fetchFollows()
    }
}

@Preview(name = "FollowsScreen")
@Composable
private fun PreviewFollowsScreen() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            FollowsScreen(
                uiState = FollowsUiState(
                    isLoading = false,
                    followsUsers = sampleUsersDummyData.map { it.toFollowingUser() }
                ),
                fetchFollows = {},
                onItemClick = {}
            )
        }
    }
}