package streafy.leasingshift2025.uikit.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class Paddings(
    val button: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
    val input: PaddingValues = PaddingValues(12.dp)
)

val LocalPaddings = staticCompositionLocalOf { Paddings() }