package uz.otamurod.socialmediakmp.common.data.network.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import uz.otamurod.socialmediakmp.BuildConfig

private const val BASE_URL = BuildConfig.BASE_URL

internal abstract class AuthApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.endPoint(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            contentType(ContentType.Application.Json)
        }
    }
}