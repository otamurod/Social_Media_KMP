package uz.otamurod.socialmediakmp.android.common.datastore.mapper

import uz.otamurod.socialmediakmp.android.common.datastore.UserSettings as UserSettingsBo
import uz.otamurod.socialmediakmp.feature.auth.domain.model.AuthResult as AuthResultDto

internal object AuthResultMapper {
    class UserSettings internal constructor(private val dto: AuthResultDto) {
        operator fun invoke(): UserSettingsBo = with(dto) {
            UserSettingsBo(id, username, bio, avatar, token, followersCount, followingCount)
        }
    }
}