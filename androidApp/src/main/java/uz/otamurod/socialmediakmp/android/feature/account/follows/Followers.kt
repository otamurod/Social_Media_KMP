package uz.otamurod.socialmediakmp.android.feature.account.follows

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import uz.otamurod.socialmediakmp.android.feature.destinations.ProfileDestination

@Composable
@Destination
fun Followers(
    navigator: DestinationsNavigator,
    userId: Long
) {
    val viewModel: FollowsViewModel = koinViewModel()

    FollowsScreen(
        uiState = viewModel.uiState,
        fetchFollows = { viewModel.fetchFollows(userId, 1) },
        onItemClick = {
            navigator.navigate(ProfileDestination(userId))
        }
    )
}