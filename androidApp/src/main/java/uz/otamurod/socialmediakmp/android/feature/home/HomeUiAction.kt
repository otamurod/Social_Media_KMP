package uz.otamurod.socialmediakmp.android.feature.home

import uz.otamurod.socialmediakmp.common.domain.model.FollowingUser
import uz.otamurod.socialmediakmp.common.domain.model.Post

sealed interface HomeUiAction {
    data class FollowUserAction(val user: FollowingUser) : HomeUiAction
    data class PostLikeAction(val post: Post) : HomeUiAction
    data object RemoveOnboardingAction : HomeUiAction
    data object RefreshAction : HomeUiAction
    data object LoadMorePostsAction : HomeUiAction
}