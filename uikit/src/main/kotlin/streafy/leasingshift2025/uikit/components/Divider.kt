package streafy.leasingshift2025.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun Divider() {
    Spacer(
        Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(LeasingTheme.colors.borderExtraLight)
    )
}