package uz.otamurod.socialmediakmp.android.feature.home.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleUsersDummyData
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.MediumSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.common.domain.model.FollowingUser

@Composable
fun OnBoardingSection(
    users: List<FollowingUser>,
    onUserClick: (FollowingUser) -> Unit,
    onFollowButtonClick: (Boolean, FollowingUser) -> Unit,
    onBoardingFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.onboarding_title),
            modifier = modifier
                .fillMaxWidth()
                .padding(top = MediumSpacing),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.oboarding_guidance_subtitle),
            modifier = modifier
                .padding(top = MediumSpacing)
                .fillMaxWidth()
                .padding(horizontal = LargeSpacing),
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = modifier.height(LargeSpacing))

        UsersRow(
            users = users,
            onUserClick = onUserClick,
            onFollowButtonClick = onFollowButtonClick
        )

        OutlinedButton(
            onClick = onBoardingFinish,
            shape = RoundedCornerShape(percent = 50),
            modifier = modifier
                .fillMaxWidth(fraction = 0.5f)
                .align(Alignment.CenterHorizontally)
                .padding(vertical = LargeSpacing)
        ) {
            Text(text = stringResource(id = R.string.onboarding_button_text))
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingSectionPreview() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            OnBoardingSection(
                users = sampleUsersDummyData.map { it.toFollowingUser() },
                onUserClick = {},
                onFollowButtonClick = { _, _ -> },
                onBoardingFinish = {}
            )
        }
    }
}