package uz.otamurod.socialmediakmp.android.common.data.dummydata

import uz.otamurod.socialmediakmp.feature.post.domain.model.PostComment

data class CommentDummyData(
    val id: String,
    val comment: String,
    val date: String,
    val authorName: String,
    val authorImageUrl: String,
    val authorId: Int,
    val postId: Long
) {
    fun toCommentBo(): PostComment {
        return PostComment(
            commentId = id.hashCode().toLong(),
            content = comment,
            createdAt = date,
            postId = postId,
            userId = authorId.toLong(),
            userName = authorName,
            userImageUrl = authorImageUrl
        )
    }
}

val sampleCommentsDummyData = listOf(
    CommentDummyData(
        id = "comment1",
        date = "2023-06-24",
        comment = "Great post!\nI learned a lot from it.",
        authorName = sampleUsersDummyData[0].name,
        authorImageUrl = sampleUsersDummyData[0].profileUrl,
        authorId = sampleUsersDummyData[0].id,
        postId = samplePostsDummyData[0].id.hashCode().toLong()
    ),
    CommentDummyData(
        id = "comment2",
        date = "2023-06-24",
        comment = "Nice work! Keep sharing more content like this.",
        authorName = sampleUsersDummyData[1].name,
        authorImageUrl = sampleUsersDummyData[1].profileUrl,
        authorId = sampleUsersDummyData[1].id,
        postId = samplePostsDummyData[0].id.hashCode().toLong()
    ),
    CommentDummyData(
        id = "comment3",
        date = "2023-06-24",
        comment = "Thanks for the insights!\nYour post was really helpful.",
        authorName = sampleUsersDummyData[2].name,
        authorImageUrl = sampleUsersDummyData[2].profileUrl,
        authorId = sampleUsersDummyData[2].id,
        postId = samplePostsDummyData[0].id.hashCode().toLong()
    ),
    CommentDummyData(
        id = "comment4",
        date = "2023-06-24",
        comment = "I enjoyed reading your post! Looking forward to more.",
        authorName = sampleUsersDummyData[3].name,
        authorImageUrl = sampleUsersDummyData[3].profileUrl,
        authorId = sampleUsersDummyData[3].id,
        postId = samplePostsDummyData[0].id.hashCode().toLong()
    )
)
