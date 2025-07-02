package streafy.leasingshift2025.uikit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class Colors(
    val bgPrimary: Color = Color(0xFFFFFFFF),
    val bgSecondary: Color = Color(0xFFF3F4F6),
    val bgTertiary: Color = Color(0xFFF9FAFB),
    val bgDisable: Color = Color(0xFFF3F4F6),
    val bgBrand: Color = Color(0xFFDB0019),
    val bgPressedPrimary: Color = Color(0xFFC10016),
    val bgHoverPrimary: Color = Color(0xFFAD0014),
    val bgBrandExtraLight: Color = Color(0xFFFF9696),

    val borderExtraLight: Color = Color(0xFFE3E5E5),
    val borderLight: Color = Color(0xFFCED2DA),
    val borderMedium: Color = Color(0xFF97A1AF),

    val textInvert: Color = Color(0xFFFFFFFF),
    val textPrimary: Color = Color(0xFF141C24),
    val textSecondary: Color = Color(0xFF344051),
    val textTertiary: Color = Color(0xFF637083),
    val textQuaternary: Color = Color(0xFF97A1AF),
    val textError: Color = Color(0xFFF64C4C),
    val textBrandDisabled: Color = Color(0xFFFF9BA6),
    val textDisabled: Color =Color(0xFFDDE1E6),

    val indicatorWhite: Color = Color(0xFFFFFFFF),
    val indicatorLight: Color = Color(0xFFCED2DA),
    val indicatorMedium: Color = Color(0xFF97A1AF),
    val indicatorNormal: Color = Color(0xFF141C24),
    val indicatorError: Color = Color(0xFFF64C4C),
    val indicatorAttention: Color = Color(0xFFFFB219),
    val indicatorPositive: Color = Color(0xFF40BF7F),
    val indicatorFocused: Color = Color(0xFFDB0019),
    val indicatorFocusedAlternative: Color = Color(0xFFDB0019)
)

val LocalColors = staticCompositionLocalOf { Colors() }
