package uz.otamurod.socialmediakmp.di

import org.koin.dsl.module
import uz.otamurod.socialmediakmp.feature.auth.data.network.api.AuthService
import uz.otamurod.socialmediakmp.feature.auth.data.repository.AuthRepository
import uz.otamurod.socialmediakmp.feature.auth.domain.api.repository.AuthRepositoryApi
import uz.otamurod.socialmediakmp.feature.auth.domain.usecase.SignInUseCase
import uz.otamurod.socialmediakmp.feature.auth.domain.usecase.SignUpUseCase
import uz.otamurod.socialmediakmp.common.util.provideDispatcher

private val authModule = module {
    single<AuthRepositoryApi> { AuthRepository(get(), get()) }
    factory { AuthService() }
    single { SignUpUseCase() }
    single { SignInUseCase() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getSharedModules() = listOf(authModule, utilityModule)