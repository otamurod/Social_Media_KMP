package uz.otamurod.socialmediakmp.feature.common.util

sealed class ResultWrapper<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ResultWrapper<T>(data)
    class Error<T>(data: T? = null, message: String) : ResultWrapper<T>(data, message)
}