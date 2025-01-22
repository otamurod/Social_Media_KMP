package uz.otamurod.socialmediakmp.android.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import uz.otamurod.socialmediakmp.android.MainActivityViewModel
import uz.otamurod.socialmediakmp.android.common.data.datastore.UserSettingsSerializer
import uz.otamurod.socialmediakmp.android.feature.account.editprofile.EditProfileViewModel
import uz.otamurod.socialmediakmp.android.feature.account.profile.ProfileViewModel
import uz.otamurod.socialmediakmp.android.feature.auth.login.LoginViewModel
import uz.otamurod.socialmediakmp.android.feature.auth.signup.SignUpViewModel
import uz.otamurod.socialmediakmp.android.feature.home.HomeScreenViewModel
import uz.otamurod.socialmediakmp.android.feature.post.PostDetailViewModel

val appModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { SignUpViewModel(get(), get()) }
    viewModel { MainActivityViewModel(get()) }
    viewModel { HomeScreenViewModel() }
    viewModel { PostDetailViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { EditProfileViewModel() }

    single {
        DataStoreFactory.create(
            serializer = UserSettingsSerializer,
            produceFile = { androidContext().dataStoreFile("user_settings.json") }
        )
    }
}