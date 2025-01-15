package uz.otamurod.socialmediakmp.android

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.map
import uz.otamurod.socialmediakmp.android.common.datastore.UserSettings
import uz.otamurod.socialmediakmp.android.common.datastore.mapper.UserSettingsMapper

class MainActivityViewModel(
    private val dataStore: DataStore<UserSettings>
) : ViewModel() {
    val authState = dataStore.data.map {
        UserSettingsMapper.AuthResult(it).invoke().token
    }
}