package uz.otamurod.socialmediakmp.android.feature.account.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import uz.otamurod.socialmediakmp.android.common.components.PostListItem
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.MediumSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.android.feature.account.profile.components.ProfileHeaderSection
import uz.otamurod.socialmediakmp.common.domain.model.Post

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    userInfoUiState: UserInfoUiState,
    profilePostsUiState: ProfilePostsUiState,
    onButtonClick: () -> Unit,
    onFollowersClick: () -> Unit,
    onFollowingClick: () -> Unit,
    onPostClick: (Post) -> Unit,
    onLikeClick: (String) -> Unit,
    onCommentClick: (String) -> Unit,
    fetchData: () -> Unit,
) {
    if (userInfoUiState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
        ) {
            item(key = "header_section") {
                ProfileHeaderSection(
                    imageUrl = userInfoUiState.profile?.imageUrl ?: "",
                    name = userInfoUiState.profile?.name ?: "",
                    bio = userInfoUiState.profile?.bio ?: "",
                    followersCount = userInfoUiState.profile?.followersCount ?: 0,
                    followingCount = userInfoUiState.profile?.followingCount ?: 0,
                    isFollowing = userInfoUiState.profile?.isFollowing ?: false,
                    isOwnProfile = userInfoUiState.profile?.isOwnProfile ?: false,
                    onButtonClick = onButtonClick,
                    onFollowersClick = onFollowersClick,
                    onFollowingClick = onFollowingClick
                )
            }

            items(
                items = profilePostsUiState.posts,
                key = { post -> post.postId }
            ) { post ->
                PostListItem(
                    post = post,
                    onPostClick = { onPostClick(post) },
                    onProfileClick = {},
                    onLikeClick = { likedPost ->

                    },
                    onCommentClick = { }
                )
            }

            if (profilePostsUiState.isLoading) {
                item(key = "loading_more_items") {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = MediumSpacing,
                                horizontal = LargeSpacing
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        fetchData()
    }
}

@Preview(name = "ProfileScreen")
@Composable
private fun PreviewProfileScreen() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            ProfileScreen(
                userInfoUiState = UserInfoUiState(),
                profilePostsUiState = ProfilePostsUiState(),
                onButtonClick = {},
                onFollowersClick = {},
                onFollowingClick = {},
                onPostClick = {},
                onLikeClick = {},
                onCommentClick = {},
                fetchData = {}
            )
        }
    }
}