package uz.otamurod.socialmediakmp.android.common.data.dummydata

import uz.otamurod.socialmediakmp.common.domain.model.FollowingUser

data class SampleFollowingUserDummyData(
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
    SampleFollowingUserDummyData(
        id = 1,
        name = "Mr Dip",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 2,
        name = "John Cena",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 3,
        name = "Cristiano",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 4,
        name = "L. James",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 5,
        name = "Emma Watson",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 6,
        name = "Elon Musk",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 7,
        name = "Taylor Swift",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 8,
        name = "Lionel Messi",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 9,
        name = "Ariana Grande",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 10,
        name = "Keanu Reeves",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 11,
        name = "Selena Gomez",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 12,
        name = "Bill Gates",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 13,
        name = "Jeff Bezos",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 14,
        name = "Chris Hemsworth",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 15,
        name = "Scarlett Johansson",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 16,
        name = "LeBron James",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 17,
        name = "Zendaya",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 18,
        name = "Tom Holland",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 19,
        name = "Dwayne Johnson",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 20,
        name = "Gal Gadot",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 21,
        name = "Robert Downey Jr.",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 22,
        name = "Chris Evans",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 23,
        name = "Emma Stone",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 24,
        name = "Ryan Reynolds",
        profileUrl = "https://picsum.photos/200"
    ),
    SampleFollowingUserDummyData(
        id = 25,
        name = "Blake Lively",
        profileUrl = "https://picsum.photos/200"
    )
)