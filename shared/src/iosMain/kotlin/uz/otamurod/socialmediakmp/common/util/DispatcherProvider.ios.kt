package uz.otamurod.socialmediakmp.common.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import uz.otamurod.socialmediakmp.common.util.DispatcherProvider

internal class IOSDispatcher : DispatcherProvider {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default
}

internal actual fun provideDispatcher(): DispatcherProvider = IOSDispatcher()