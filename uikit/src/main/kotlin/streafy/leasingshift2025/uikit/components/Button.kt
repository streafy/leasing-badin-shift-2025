package streafy.leasingshift2025.uikit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import streafy.leasingshift2025.uikit.theme.LeasingTheme
import androidx.compose.material3.Button as MaterialButton

enum class ButtonVariant {
    Primary, PrimaryDark, Outline, Text
}

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: ButtonVariant = ButtonVariant.Primary,
    content: @Composable RowScope.() -> Unit,
) {
    val colors = when (variant) {
        ButtonVariant.Primary -> ButtonDefaults.buttonColors(
            containerColor = LeasingTheme.colors.bgBrand,
            contentColor = LeasingTheme.colors.textInvert,
        )
        ButtonVariant.PrimaryDark -> ButtonDefaults.buttonColors(
            containerColor = LeasingTheme.colors.textSecondary,
            contentColor = LeasingTheme.colors.textInvert,
        )
        ButtonVariant.Outline -> ButtonDefaults.buttonColors(
            containerColor = LeasingTheme.colors.bgPrimary,
            contentColor = LeasingTheme.colors.textSecondary,
        )
        ButtonVariant.Text -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = LeasingTheme.colors.textSecondary,
        )
    }

    val border = when (variant) {
        ButtonVariant.Primary -> null
        ButtonVariant.PrimaryDark -> null
        ButtonVariant.Outline -> BorderStroke(1.dp, LeasingTheme.colors.borderLight)
        ButtonVariant.Text -> null
    }

    MaterialButton(
        onClick = onClick,
        modifier = modifier,
        shape = LeasingTheme.shapes.button,
        colors = colors,
        border = border,
        contentPadding = LeasingTheme.paddings.button
    ) {
        ProvideTextStyle(
            value = LeasingTheme.typography.button
        ) {
            content()
        }
    }
}

