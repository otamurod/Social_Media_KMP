package uz.otamurod.socialmediakmp.android.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(text = "HomeScreen")
    }
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}