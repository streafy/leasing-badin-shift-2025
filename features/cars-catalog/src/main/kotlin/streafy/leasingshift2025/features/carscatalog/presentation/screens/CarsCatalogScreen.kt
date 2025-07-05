package streafy.leasingshift2025.features.carscatalog.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import streafy.leasingshift2025.features.carscatalog.R
import streafy.leasingshift2025.features.carscatalog.domain.Car
import streafy.leasingshift2025.features.carscatalog.presentation.CarsCatalogState
import streafy.leasingshift2025.features.carscatalog.presentation.CarsCatalogViewModel
import streafy.leasingshift2025.features.carscatalog.presentation.components.CarCard
import streafy.leasingshift2025.shared.LocalViewModelFactory
import streafy.leasingshift2025.uikit.components.ErrorMessage
import streafy.leasingshift2025.uikit.components.Loading
import streafy.leasingshift2025.uikit.components.Button
import streafy.leasingshift2025.uikit.components.ButtonVariant
import streafy.leasingshift2025.uikit.components.Input
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun CarsCatalogScreen(
    viewModel: CarsCatalogViewModel = viewModel(factory = LocalViewModelFactory.current)
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getCarsCatalog()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        header()
        filters { viewModel.openFiltersScreen() }
        when (val currentState = state) {
            CarsCatalogState.Initial,
            CarsCatalogState.Loading -> loading()

            is CarsCatalogState.Content -> content(
                cars = currentState.cars,
                onCarClicked = { id -> viewModel.openCarCard(id) })

            is CarsCatalogState.Error -> error(
                currentState.message
            ) { viewModel.getCarsCatalog() }
        }

    }
}

fun LazyListScope.loading() {
    item {
        Loading()
    }
}

fun LazyListScope.content(
    cars: List<Car>,
    onCarClicked: (String) -> Unit
) {
    items(
        items = cars,
        key = { car -> car.id }
    ) { car ->
        CarCard(
            car = car,
            onCarClicked = { onCarClicked(car.id) },
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

fun LazyListScope.error(message: String, onRetry: () -> Unit) {
    item {
        ErrorMessage(message, onRetry)
    }
}

fun LazyListScope.header() {
    item {
        Text(
            text = "Автомобили",
            modifier = Modifier
                .fillMaxWidth()
                .background(LeasingTheme.colors.bgPrimary)
                .padding(vertical = 12.dp),
            color = LeasingTheme.colors.textPrimary,
            textAlign = TextAlign.Start,
            style = LeasingTheme.typography.titleLg
        )
    }
}

fun LazyListScope.filters(
    onFiltersButtonClick: () -> Unit
) {
    item {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Input(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.cars_catalog_search),
                placeholder = stringResource(R.string.cars_catalog_search_placeholder)
            )
            Input(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.cars_catalog_rent_dates),
                placeholder = stringResource(R.string.cars_catalog_rent_dates_placeholder)
            )
            Button(
                onClick = onFiltersButtonClick,
                modifier = Modifier.fillMaxWidth(),
                variant = ButtonVariant.PrimaryDark
            ) {
                Text(text = stringResource(R.string.cars_catalog_filters))
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}