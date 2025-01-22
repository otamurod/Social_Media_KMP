package uz.otamurod.socialmediakmp.android.feature.account.editprofile.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.theming.Gray
import uz.otamurod.socialmediakmp.android.common.theming.SocialAppTheme

@Composable
fun BioTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp),
        value = value,
        onValueChange = {
            onValueChange(
                TextFieldValue(
                    text = it.text,
                    selection = TextRange(it.text.length)
                )
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = if (isSystemInDarkTheme()) {
                MaterialTheme.colors.surface
            } else {
                Gray
            },
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        textStyle = MaterialTheme.typography.body2,
        placeholder = {
            Text(
                text = stringResource(id = R.string.user_bio_hint),
                style = MaterialTheme.typography.body2
            )
        },
        shape = MaterialTheme.shapes.medium
    )
}

@Preview(name = "BioTextField")
@Composable
private fun PreviewBioTextField() {
    SocialAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            BioTextField(
                modifier = Modifier,
                value = TextFieldValue(""),
                onValueChange = {}
            )
        }
    }
}