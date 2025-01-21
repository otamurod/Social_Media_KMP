package uz.otamurod.socialmediakmp.android.common.data.datastore.mapper

import uz.otamurod.socialmediakmp.android.common.data.datastore.UserSettings as UserSettingsDto
import uz.otamurod.socialmediakmp.feature.auth.domain.model.AuthResult as AuthResultBo

internal object UserSettingsMapper {
    class AuthResult internal constructor(private val dto: UserSettingsDto) {
        operator fun invoke(): AuthResultBo = with(dto) {
            AuthResultBo(id, username, bio, avatar, token, followersCount, followingCount)
        }
    }
}