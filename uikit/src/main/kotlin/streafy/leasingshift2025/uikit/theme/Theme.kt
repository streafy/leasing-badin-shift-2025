package streafy.leasingshift2025.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun LeasingTheme(
    colors: Colors = LeasingTheme.colors,
    typography: Typography = LeasingTheme.typography,
    shapes: Shapes = LeasingTheme.shapes,
    paddings: Paddings = LeasingTheme.paddings,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
        LocalPaddings provides paddings,
        content = content
    )
}

object LeasingTheme {
    val colors: Colors
        @Composable get() = LocalColors.current
    val typography: Typography
        @Composable get() = LocalTypography.current
    val shapes: Shapes
        @Composable get() = LocalShapes.current
    val paddings: Paddings
        @Composable get() = LocalPaddings.current
}