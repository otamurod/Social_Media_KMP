package uz.otamurod.socialmediakmp.android.feature.account.follows

sealed interface FollowsUiAction {
    data class FetchFollowsAction(val userId: Long, val followsType: Int) : FollowsUiAction
    data object LoadMoreFollowsAction : FollowsUiAction
}