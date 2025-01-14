package uz.otamurod.socialmediakmp.android.common.components

import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import uz.otamurod.socialmediakmp.android.R
import uz.otamurod.socialmediakmp.android.common.theming.Gray

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordTextField: Boolean = false,
    isSingleLine: Boolean = true,
    @StringRes hint: Int,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.body2,
        placeholder = {
            Text(text = stringResource(id = hint), style = MaterialTheme.typography.body2)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        singleLine = isSingleLine,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = if (isSystemInDarkTheme()) {
                MaterialTheme.colors.surface
            } else {
                Gray
            },
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = if (isPasswordTextField) {
            {
                PasswordEyeIcon(isPasswordVisible = isPasswordVisible) {
                    isPasswordVisible = !isPasswordVisible
                }
            }
        } else {
            null
        },
        visualTransformation = if (isPasswordTextField) {
            if (isPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        } else {
            VisualTransformation.None
        },
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
private fun PasswordEyeIcon(
    isPasswordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit
) {
    val icon = if (isPasswordVisible) {
        painterResource(id = R.drawable.show_eye_icon_filled)
    } else {
        painterResource(id = R.drawable.hide_eye_icon_filled)
    }

    IconButton(onClick = onPasswordVisibilityToggle) {
        Icon(painter = icon, contentDescription = null)
    }
}

@Preview(name = "CustomTextField")
@Composable
private fun PreviewCustomTextField() {
    CustomTextField(
        value = "",
        onValueChange = {},
        hint = androidx.compose.ui.R.string.default_error_message
    )
}