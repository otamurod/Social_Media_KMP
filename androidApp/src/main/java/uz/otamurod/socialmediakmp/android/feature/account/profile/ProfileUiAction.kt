package uz.otamurod.socialmediakmp.android.feature.account.profile

import uz.otamurod.socialmediakmp.common.domain.model.Post
import uz.otamurod.socialmediakmp.feature.account.domain.model.Profile

sealed interface ProfileUiAction {
    data class FetchProfileAction(val profileId: Long) : ProfileUiAction
    data class FollowUserAction(val profile: Profile) : ProfileUiAction
    data object LoadMorePostsAction : ProfileUiAction
    data class PostLikeAction(val post: Post) : ProfileUiAction
}