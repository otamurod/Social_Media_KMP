package uz.otamurod.socialmediakmp.android.feature.home

data class HomeRefreshState(
    val isRefreshing: Boolean = false,
    val refreshErrorMessage: String? = null
)