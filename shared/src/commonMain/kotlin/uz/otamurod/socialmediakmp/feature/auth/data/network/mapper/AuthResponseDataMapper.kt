package uz.otamurod.socialmediakmp.feature.auth.data.network.mapper

import uz.otamurod.socialmediakmp.feature.auth.data.network.api.entities.response.AuthResponseData as AuthResponseDto
import uz.otamurod.socialmediakmp.feature.auth.domain.model.AuthResult as AuthResultBo

internal object AuthResponseDataMapper {
    class AuthResult internal constructor(private val dto: AuthResponseDto) {
        operator fun invoke(): AuthResultBo = with(dto) {
            AuthResultBo(id, username, bio, avatar, token, followersCount, followingCount)
        }
    }
}