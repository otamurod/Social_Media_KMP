package uz.otamurod.socialmediakmp.android.feature.auth.login

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import uz.otamurod.socialmediakmp.android.feature.destinations.HomeScreenDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.LoginDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.SignUpDestination

@Destination
@Composable
fun Login(
    navigator: DestinationsNavigator
) {
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onSignInClick = viewModel::signIn,
        onNavigateToHome = {
            navigator.navigate(HomeScreenDestination) {
                popUpTo(LoginDestination.route) { inclusive = true }
            }
        },
        onNavigateToSignup = {
            navigator.navigate(SignUpDestination.route) {
                popUpTo(LoginDestination.route) {
                    inclusive = true
                }
            }
        }
    )
}