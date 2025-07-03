package streafy.leasingshift2025.uikit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun Input(
    modifier: Modifier = Modifier,
    label: String? = null,
    hint: String? = null,
    errorMessage: String? = null,
    placeholder: String? = null
) {
    val state = rememberTextFieldState()

    Column(
        modifier = modifier.width(320.dp)
    ) {
        if (label != null) {
            Text(
                text = label,
                color = LeasingTheme.colors.textPrimary,
                style = LeasingTheme.typography.paragraphRegularS
            )
            Spacer(modifier = Modifier.size(6.dp))
        }
        OutlinedTextField(
            state = state,
            modifier = modifier.height(48.dp),
            textStyle = LeasingTheme.typography.paragraphRegularM,
            placeholder = {
                Text(
                    text = placeholder ?: "",
                    color = LeasingTheme.colors.textTertiary,
                    style = LeasingTheme.typography.paragraphRegularM
                )
            },
            lineLimits = TextFieldLineLimits.SingleLine,
            shape = LeasingTheme.shapes.input,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = LeasingTheme.colors.textPrimary,
                unfocusedTextColor = LeasingTheme.colors.textTertiary,
                disabledTextColor = LeasingTheme.colors.textTertiary,
                unfocusedContainerColor = LeasingTheme.colors.bgPrimary,
                focusedContainerColor = LeasingTheme.colors.bgPrimary,
                disabledContainerColor = LeasingTheme.colors.bgDisable,
                errorContainerColor = LeasingTheme.colors.bgPrimary,
                unfocusedBorderColor = LeasingTheme.colors.borderLight,
                focusedBorderColor = LeasingTheme.colors.indicatorFocused,
                cursorColor = LeasingTheme.colors.indicatorFocused,
                selectionColors = TextSelectionColors(
                    handleColor = LeasingTheme.colors.indicatorFocused,
                    backgroundColor = LeasingTheme.colors.bgBrandExtraLight
                )
            ),
            contentPadding = LeasingTheme.paddings.input,
        )
        if (hint != null || errorMessage == null) {
            val text = errorMessage ?: hint ?: ""
            val color =
                if (errorMessage != null) LeasingTheme.colors.textError else LeasingTheme.colors.textTertiary
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = text,
                color = color,
                style = LeasingTheme.typography.paragraphRegularS
            )
        }
    }
}