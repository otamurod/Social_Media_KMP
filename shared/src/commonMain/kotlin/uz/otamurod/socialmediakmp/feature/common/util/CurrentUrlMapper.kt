package uz.otamurod.socialmediakmp.feature.common.util

import uz.otamurod.socialmediakmp.BuildConfig

private const val CURRENT_BASE_URL = BuildConfig.BASE_URL

fun String.toCurrentUrl(): String {
    return try {
        "$CURRENT_BASE_URL${this.substring(26)}"
    } catch (error: Throwable) {
        this
    }
}