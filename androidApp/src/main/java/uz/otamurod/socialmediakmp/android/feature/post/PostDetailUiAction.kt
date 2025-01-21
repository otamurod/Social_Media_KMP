package uz.otamurod.socialmediakmp.android.feature.post

import uz.otamurod.socialmediakmp.feature.common.domain.model.Post
import uz.otamurod.socialmediakmp.feature.post.domain.model.PostComment

sealed interface PostDetailUiAction {
    data class FetchPostAction(val postId: Long) : PostDetailUiAction
    data object LoadMoreCommentsAction : PostDetailUiAction
    data class LikeOrDislikePostAction(val post: Post) : PostDetailUiAction
    data class AddCommentAction(val comment: String) : PostDetailUiAction
    data class RemoveCommentAction(val postComment: PostComment) : PostDetailUiAction
}