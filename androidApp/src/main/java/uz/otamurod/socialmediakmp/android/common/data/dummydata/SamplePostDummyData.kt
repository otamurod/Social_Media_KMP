package uz.otamurod.socialmediakmp.android.common.data.dummydata

import uz.otamurod.socialmediakmp.common.domain.model.Post
import uz.otamurod.socialmediakmp.common.util.DateFormatter

data class SamplePostDummyData(
    val id: Long,
    val text: String,
    val imageUrl: String,
    val createdAt: String,
    val likesCount: Int,
    val commentCount: Int,
    val authorId: Int,
    val authorName: String,
    val authorImage: String,
    val isLiked: Boolean = false,
    val isOwnPost: Boolean = false
) {
    fun toPostBo(): Post {
        return Post(
            postId = id,
            caption = text,
            imageUrl = imageUrl,
            createdAt = DateFormatter.parseDate(createdAt),
            likesCount = likesCount,
            commentsCount = commentCount,
            userId = authorId.toLong(),
            userName = authorName,
            userImageUrl = authorImage,
            isLiked = isLiked,
            isOwnPost = isOwnPost
        )
    }
}

val samplePostsDummyData = listOf(
    SamplePostDummyData(
        id = 101,
        text = "Exploring the mountains today was an exhilarating experience! The fresh air and breathtaking views were unforgettable.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Jan 10, 2024",
        likesCount = 54,
        commentCount = 12,
        authorId = 1,
        authorName = "Alex Carter",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 102,
        text = "Had a blast at the beach today! The sunset was truly magical 🌅.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Feb 15, 2024",
        likesCount = 89,
        commentCount = 21,
        authorId = 2,
        authorName = "Sophia Lopez",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 103,
        text = "Nothing beats a cozy evening with a good book and a cup of coffee ☕.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Mar 20, 2024",
        likesCount = 112,
        commentCount = 34,
        authorId = 3,
        authorName = "Liam Johnson",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 104,
        text = "Just completed my first marathon today! Feeling proud and exhausted at the same time 🏃‍♂️.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Apr 05, 2024",
        likesCount = 76,
        commentCount = 15,
        authorId = 4,
        authorName = "Emma Davis",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 105,
        text = "Visited a local art gallery and was blown away by the creativity on display 🎨.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "May 18, 2024",
        likesCount = 102,
        commentCount = 28,
        authorId = 5,
        authorName = "Noah Wilson",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 106,
        text = "Weekend getaway to the countryside. The peace and quiet are unmatched 🌲.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Jun 25, 2024",
        likesCount = 134,
        commentCount = 43,
        authorId = 6,
        authorName = "Mia Thompson",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 107,
        text = "Experimented with a new recipe today. The kitchen might be a mess, but it was worth it 🍳.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Jul 04, 2024",
        likesCount = 67,
        commentCount = 19,
        authorId = 7,
        authorName = "Oliver Brown",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 108,
        text = "The city skyline looked stunning tonight! What a view 🌃.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Aug 12, 2024",
        likesCount = 145,
        commentCount = 38,
        authorId = 8,
        authorName = "Charlotte Evans",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 109,
        text = "Tried a new yoga routine this morning. Feeling refreshed and energized 🧘‍♀️.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Sep 02, 2024",
        likesCount = 78,
        commentCount = 14,
        authorId = 9,
        authorName = "Ethan Harris",
        authorImage = "https://picsum.photos/200"
    ),
    SamplePostDummyData(
        id = 110,
        text = "Caught an amazing sunrise during my morning jog 🌄.",
        imageUrl = "https://picsum.photos/400",
        createdAt = "Oct 08, 2024",
        likesCount = 92,
        commentCount = 22,
        authorId = 10,
        authorName = "Amelia White",
        authorImage = "https://picsum.photos/200"
    )
)