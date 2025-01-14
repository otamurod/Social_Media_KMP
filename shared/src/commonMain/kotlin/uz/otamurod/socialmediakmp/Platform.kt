package uz.otamurod.socialmediakmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform