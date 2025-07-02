package streafy.leasingshift2025.uikit.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class Shapes(
    val button: CornerBasedShape = ShapeDefaults.Large,
    val input: CornerBasedShape = ShapeDefaults.Small
)

val LocalShapes = staticCompositionLocalOf { Shapes() }