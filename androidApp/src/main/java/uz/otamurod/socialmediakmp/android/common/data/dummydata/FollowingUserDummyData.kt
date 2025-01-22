package uz.otamurod.socialmediakmp.android.common.data.dummydata

import uz.otamurod.socialmediakmp.common.domain.model.FollowingUser

data class FollowingUserDummyData(
    val id: Int,
    val name: String,
    val bio: String = "Hey there, welcome to my social app page!",
    val profileUrl: String,
    val isFollowing: Boolean = false
) {
    fun toFollowingUser(): FollowingUser {
        return FollowingUser(
            id = id.toLong(),
            name = name,
            bio = bio,
            imageUrl = profileUrl,
            isFollowing = isFollowing
        )
    }
}

val sampleUsersDummyData = listOf(
    FollowingUserDummyData(
        id = 1,
        name = "Mr Dip",
        profileUrl = "https://picsum.photos/200"
    ),
    FollowingUserDummyData(
        id = 2,
        name = "John Cena",
        profileUrl = "https://picsum.photos/200"
    ),
    FollowingUserDummyData(
        id = 3,
        name = "Cristiano",
        profileUrl = "https://picsum.photos/200"
    ),
    FollowingUserDummyData(
        id = 4,
        name = "L. James",
        profileUrl = "https://picsum.photos/200"
    )
)