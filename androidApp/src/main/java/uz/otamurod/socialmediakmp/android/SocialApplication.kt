package uz.otamurod.socialmediakmp.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uz.otamurod.socialmediakmp.android.di.appModule
import uz.otamurod.socialmediakmp.feature.di.getSharedModules

class SocialApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SocialApplication)
            modules(appModule + getSharedModules())
        }
    }
}