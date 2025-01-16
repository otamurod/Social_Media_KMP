package uz.otamurod.socialmediakmp.android.common.dummy_data

data class ProfileDummyData(
    val id: Int,
    val name: String,
    val bio: String,
    val profileUrl: String,
    val followersCount: Int,
    val followingCount: Int,
    val isOwnProfile: Boolean = false,
    val isFollowing: Boolean = false
)

val sampleProfilesDummyData = listOf(
    ProfileDummyData(
        id = 1,
        name = "Mr Dip",
        bio = "Hey there, welcome to my Social App page!",
        profileUrl = "https://picsum.photos/200",
        followersCount = 23,
        followingCount = 13,
        isOwnProfile = true,
        isFollowing = true
    ),

    ProfileDummyData(
        id = 2,
        name = "John Cena",
        profileUrl = "https://picsum.photos/200",
        bio = "Hey there, welcome to my Social App page!",
        followersCount = 23,
        followingCount = 13,
        isOwnProfile = true,
        isFollowing = true
    ),

    ProfileDummyData(
        id = 3,
        name = "Cristiano",
        profileUrl = "https://picsum.photos/200",
        bio = "Hey there, welcome to my Social App page!",
        followersCount = 23,
        followingCount = 13,
        isOwnProfile = true,
        isFollowing = true
    ),

    ProfileDummyData(
        id = 4,
        name = "L. James",
        profileUrl = "https://picsum.photos/200",
        bio = "Hey there, welcome to my Social App page!",
        followersCount = 23,
        followingCount = 13,
        isOwnProfile = true,
        isFollowing = true
    )
)