package uz.otamurod.socialmediakmp.android.feature.auth.signup

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import uz.otamurod.socialmediakmp.android.feature.destinations.HomeScreenDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.LoginDestination
import uz.otamurod.socialmediakmp.android.feature.destinations.SignUpDestination

@Destination
@Composable
fun SignUp(
    navigator: DestinationsNavigator
) {
    val viewModel: SignUpViewModel = koinViewModel()

    SignUpScreen(
        uiState = viewModel.uiState,
        onUsernameChange = viewModel::updateUsername,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToLogin = {
            navigator.navigate(LoginDestination) {
                popUpTo(SignUpDestination.route) {
                    inclusive = true
                }
            }
        },
        onNavigateToHome = {
            navigator.navigate(HomeScreenDestination) {
                popUpTo(SignUpDestination.route) { inclusive = true }
            }
        },
        onSignUpClick = viewModel::signUp
    )
}