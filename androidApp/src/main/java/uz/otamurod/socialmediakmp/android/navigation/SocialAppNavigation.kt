package uz.otamurod.socialmediakmp.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import uz.otamurod.socialmediakmp.android.feature.NavGraphs

@Composable
fun SocialAppNavigation() {
    val navHostController = rememberNavController()

    DestinationsNavHost(navGraph = NavGraphs.root, navController = navHostController)
}

@Preview(name = "SocialAppNavigation")
@Composable
private fun PreviewSocialAppNavigation() {
    SocialAppNavigation()
}