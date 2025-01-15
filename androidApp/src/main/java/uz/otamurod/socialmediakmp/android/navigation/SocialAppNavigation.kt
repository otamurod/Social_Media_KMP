package uz.otamurod.socialmediakmp.android.navigation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import uz.otamurod.socialmediakmp.android.common.components.AppBar
import uz.otamurod.socialmediakmp.android.feature.NavGraphs

@Composable
fun SocialAppNavigation() {
    val navHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val systemUiController = rememberSystemUiController()
    val isDarkMode = isSystemInDarkTheme()

    val statusBarColor = if (isDarkMode) {
        MaterialTheme.colors.surface
    } else {
        MaterialTheme.colors.surface.copy(alpha = 0.95f)
    }

    SideEffect {
        systemUiController.setSystemBarsColor(color = statusBarColor, darkIcons = !isDarkMode)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(navHostController = navHostController)
        },
    ) { innerPadding ->
        DestinationsNavHost(
            modifier = Modifier.padding(innerPadding),
            navGraph = NavGraphs.root,
            navController = navHostController
        )
    }
}

@Preview(name = "SocialAppNavigation")
@Composable
private fun PreviewSocialAppNavigation() {
    SocialAppNavigation()
}