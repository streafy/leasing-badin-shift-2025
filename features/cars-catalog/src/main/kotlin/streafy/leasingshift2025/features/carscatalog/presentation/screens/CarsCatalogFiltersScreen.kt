package streafy.leasingshift2025.features.carscatalog.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import streafy.leasingshift2025.features.carscatalog.R
import streafy.leasingshift2025.uikit.components.Button
import streafy.leasingshift2025.uikit.components.ButtonVariant

@Composable
fun CarsCatalogFiltersScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text("Тут будут фильтры...")
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            variant = ButtonVariant.Outline
        ) {
            Text(text = stringResource(R.string.cars_catalog_filters_reset_all))
        }
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            variant = ButtonVariant.Primary
        ) {
            Text(text = stringResource(R.string.cars_catalog_filters_search))
        }
    }
}