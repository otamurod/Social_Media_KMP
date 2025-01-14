package uz.otamurod.socialmediakmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.android.navigation.SocialAppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SocialAppNavigation()
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    SocialAppTheme {
        SocialAppNavigation()
    }
}
