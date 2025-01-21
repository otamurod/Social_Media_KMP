package uz.otamurod.socialmediakmp.android.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.theming.SmallElevation
import uz.otamurod.socialmediakmp.android.feature.destinations.HomeDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.LoginDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.PostDetailDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.SignUpDestination

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    val currentDestination = navHostController.currentDestinationAsState().value

    Surface(
        modifier = modifier,
        elevation = SmallElevation,
    ) {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(text = stringResource(id = getAppBarTitle(currentDestination?.route)))
            },
            backgroundColor = MaterialTheme.colors.surface,
            actions = {
                AnimatedVisibility(visible = currentDestination?.route == HomeDestination.route) {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.person_circle_icon),
                            contentDescription = null
                        )
                    }
                }
            },
            navigationIcon = when {
                shouldShowNavigationIcon(currentDestination?.route) -> ({
                    IconButton(
                        onClick = { navHostController.navigateUp() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.round_arrow_back),
                            contentDescription = null
                        )
                    }
                })

                else -> null
            }
        )
    }
}

private fun getAppBarTitle(currentDestinationRoute: String?): Int {
    return when (currentDestinationRoute) {
        LoginDestination.route -> R.string.login_destination_title
        SignUpDestination.route -> R.string.signup_destination_title
        HomeDestination.route -> R.string.home_destination_title
        PostDetailDestination.route -> R.string.post_detail_destination_title
        else -> R.string.no_destination_title
    }
}

private fun shouldShowNavigationIcon(currentDestinationRoute: String?): Boolean {
    return !(currentDestinationRoute == LoginDestination.route ||
            currentDestinationRoute == SignUpDestination.route ||
            currentDestinationRoute == HomeDestination.route ||
            currentDestinationRoute == null
            )
}

@Preview(name = "AppBar")
@Composable
private fun PreviewAppBar() {
    AppBar(
        modifier = Modifier,
        navHostController = rememberNavController()
    )
}