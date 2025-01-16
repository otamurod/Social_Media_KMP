package uz.otamurod.socialmediakmp.android.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.theming.DarkGray
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.LightGray
import uz.otamurod.socialmediakmp.android.common.theming.MediumSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.feature.common.util.toCurrentUrl

@Composable
fun PostHeader(
    modifier: Modifier = Modifier,
    name: String,
    profileUrl: String?,
    date: String,
    onProfileClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = LargeSpacing,
                vertical = MediumSpacing
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MediumSpacing)
    ) {
        CircleImage(
            modifier = modifier.size(30.dp),
            url = profileUrl?.toCurrentUrl(),
            onClick = onProfileClick
        )

        Text(
            text = name,
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onSurface
        )

        Box(
            modifier = modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(
                    color = if (MaterialTheme.colors.isLight) {
                        LightGray
                    } else {
                        DarkGray
                    }
                )
        )

        Text(
            text = date,
            style = MaterialTheme.typography.caption.copy(
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = if (MaterialTheme.colors.isLight) {
                    LightGray
                } else {
                    DarkGray
                }
            ),
            modifier = modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.round_more_horizontal),
            contentDescription = null,
            tint = if (MaterialTheme.colors.isLight) {
                LightGray
            } else {
                DarkGray
            }
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PostHeaderPreview() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.surface) {
            PostHeader(
                name = "Otamurod",
                profileUrl = "",
                date = "10 min",
                onProfileClick = {}
            )
        }
    }
}