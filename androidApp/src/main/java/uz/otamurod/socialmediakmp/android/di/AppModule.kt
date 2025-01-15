package uz.otamurod.socialmediakmp.android.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import uz.otamurod.socialmediakmp.android.MainActivityViewModel
import uz.otamurod.socialmediakmp.android.common.datastore.UserSettingsSerializer
import uz.otamurod.socialmediakmp.android.feature.auth.login.LoginViewModel
import uz.otamurod.socialmediakmp.android.feature.auth.signup.SignUpViewModel

val appModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { SignUpViewModel(get(), get()) }
    viewModel { MainActivityViewModel(get()) }

    single {
        DataStoreFactory.create(
            serializer = UserSettingsSerializer,
            produceFile = { androidContext().dataStoreFile("user_settings.json") }
        )
    }
}