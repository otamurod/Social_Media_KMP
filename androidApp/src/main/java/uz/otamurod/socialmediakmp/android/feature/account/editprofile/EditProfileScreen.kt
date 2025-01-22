package uz.otamurod.socialmediakmp.android.feature.account.editprofile

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.components.CircleImage
import uz.otamurod.socialmediakmp.android.common.components.CustomTextField
import uz.otamurod.socialmediakmp.android.common.data.dummydata.sampleProfilesDummyData
import uz.otamurod.socialmediakmp.android.common.theming.ButtonHeight
import uz.otamurod.socialmediakmp.android.common.theming.ExtraLargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.SmallElevation
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme
import uz.otamurod.socialmediakmp.android.feature.account.editprofile.components.BioTextField
import uz.otamurod.socialmediakmp.common.util.toCurrentUrl

@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    editProfileUiState: EditProfileUiState,
    onNameChange: (String) -> Unit,
    bioTextFieldValue: TextFieldValue,
    onBioChange: (TextFieldValue) -> Unit,
    onUploadButtonClick: () -> Unit,
    onUploadSucceed: () -> Unit,
    fetchProfile: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            editProfileUiState.profile != null -> {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(
                            color = if (isSystemInDarkTheme()) {
                                MaterialTheme.colors.background
                            } else {
                                MaterialTheme.colors.surface
                            }
                        )
                        .padding(ExtraLargeSpacing),
                    verticalArrangement = Arrangement.spacedBy(LargeSpacing),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box {
                        CircleImage(
                            modifier = modifier.size(120.dp),
                            url = editProfileUiState.profile.imageUrl?.toCurrentUrl(),
                            onClick = {}
                        )

                        IconButton(
                            onClick = {},
                            modifier = modifier
                                .align(Alignment.BottomEnd)
                                .shadow(
                                    elevation = SmallElevation,
                                    shape = RoundedCornerShape(percent = 25)
                                )
                                .background(
                                    color = MaterialTheme.colors.surface,
                                    shape = RoundedCornerShape(percent = 25)
                                )
                                .size(40.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Edit,
                                contentDescription = null,
                                tint = MaterialTheme.colors.primary
                            )
                        }
                    }

                    Spacer(modifier = modifier.height(LargeSpacing))

                    CustomTextField(
                        value = editProfileUiState.profile.name,
                        onValueChange = onNameChange,
                        hint = R.string.username_hint
                    )

                    BioTextField(value = bioTextFieldValue, onValueChange = onBioChange)

                    Button(
                        onClick = {
                            onUploadButtonClick()
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .height(ButtonHeight),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp
                        ),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(text = stringResource(id = R.string.upload_changes_text))
                    }
                }
            }

            editProfileUiState.errorMessage != null -> {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = R.string.loading_error_message),
                        style = MaterialTheme.typography.caption.copy(textAlign = TextAlign.Center)
                    )

                    OutlinedButton(
                        onClick = fetchProfile,
                        shape = RoundedCornerShape(percent = 50),
                        contentPadding = PaddingValues(horizontal = ExtraLargeSpacing)
                    ) {
                        Text(text = stringResource(id = R.string.retry_button_text))
                    }
                }
            }
        }

        if (editProfileUiState.isLoading) {
            CircularProgressIndicator()
        }
    }

    LaunchedEffect(Unit) { fetchProfile() }

    LaunchedEffect(
        key1 = editProfileUiState.uploadSucceed,
        key2 = editProfileUiState.errorMessage
    ) {
        if (editProfileUiState.uploadSucceed) {
            onUploadSucceed()
        }

        if (editProfileUiState.profile != null && editProfileUiState.errorMessage != null) {
            Toast.makeText(context, editProfileUiState.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}

@Preview(name = "EditProfileScreen")
@Composable
private fun PreviewEditProfileScreen() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            EditProfileScreen(
                modifier = Modifier,
                editProfileUiState = EditProfileUiState(
                    isLoading = false,
                    profile = sampleProfilesDummyData.first().toProfileBo(),
                    uploadSucceed = false,
                    errorMessage = null
                ),
                onNameChange = {},
                bioTextFieldValue = TextFieldValue(""),
                onBioChange = {},
                onUploadButtonClick = {},
                onUploadSucceed = {},
                fetchProfile = {},
            )
        }
    }
}