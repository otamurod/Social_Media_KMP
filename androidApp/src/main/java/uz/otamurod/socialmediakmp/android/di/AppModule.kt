package uz.otamurod.socialmediakmp.android.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import uz.otamurod.socialmediakmp.android.feature.auth.login.LoginViewModel
import uz.otamurod.socialmediakmp.android.feature.auth.signup.SignUpViewModel

val appModule = module {
    viewModel { LoginViewModel() }
    viewModel { SignUpViewModel() }
}