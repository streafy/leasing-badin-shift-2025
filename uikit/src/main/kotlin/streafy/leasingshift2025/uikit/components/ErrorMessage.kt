package streafy.leasingshift2025.uikit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import streafy.leasingshift2025.uikit.R
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun ErrorMessage(
    message: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            style = LeasingTheme.typography.paragraphRegularM
        )
        Button(onClick = onRetry, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.error_message_retry))
        }
    }
}