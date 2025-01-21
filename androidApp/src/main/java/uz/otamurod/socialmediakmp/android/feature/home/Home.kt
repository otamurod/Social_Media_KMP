package uz.otamurod.socialmediakmp.android.feature.home

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import uz.otamurod.socialmediakmp.android.feature.destinations.PostDetailDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.ProfileDestination

@Composable
@Destination(start = true)
fun Home(
    navigator: DestinationsNavigator
) {
    val viewModel: HomeScreenViewModel = koinViewModel()

    HomeScreen(
        onBoardingUiState = viewModel.onBoardingUiState,
        postsFeedUiState = viewModel.postsFeedUiState,
        homeRefreshState = viewModel.homeRefreshState,
        onUiAction = { /* TODO */ },
        onProfileNavigation = {navigator.navigate(ProfileDestination(it))},
        onPostDetailNavigation = { navigator.navigate(PostDetailDestination(it.postId)) }
    )
}