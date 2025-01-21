package uz.otamurod.socialmediakmp.common.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}

internal expect fun provideDispatcher(): DispatcherProvider