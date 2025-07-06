package streafy.leasingshift2025.features.cardetails.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import streafy.leasingshift2025.features.cardetails.R
import streafy.leasingshift2025.features.cardetails.domain.CarDetails
import streafy.leasingshift2025.shared.LocalViewModelFactory
import streafy.leasingshift2025.uikit.components.Button
import streafy.leasingshift2025.uikit.components.ButtonVariant
import streafy.leasingshift2025.uikit.components.Divider
import streafy.leasingshift2025.uikit.components.ErrorMessage
import streafy.leasingshift2025.uikit.components.Loading
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun CarDetailsScreen(
    id: String,
    rentStart: Long,
    rentEnd: Long,
    viewModel: CarDetailsViewModel = viewModel(factory = LocalViewModelFactory.current)
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getCar(id)
    }
    when (val currentState = state) {
        CarDetailsState.Initial, CarDetailsState.Loading -> Loading()

        is CarDetailsState.Content -> Content(
            carDetails = currentState.carDetails,
            rentStart = rentStart,
            rentEnd = rentEnd,
            onBack = viewModel::back
        )

        is CarDetailsState.Error -> ErrorMessage(
            message = currentState.message,
            onRetry = {
                viewModel.getCar(id)
            }
        )
    }
}

@Composable
private fun Content(
    carDetails: CarDetails,
    rentStart: Long,
    rentEnd: Long,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(LeasingTheme.colors.bgPrimary)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.arrow_left),
                contentDescription = null,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onBack
                ),
                colorFilter = ColorFilter.tint(LeasingTheme.colors.indicatorLight)
            )
            Text(
                text = "Автомобили",
                color = LeasingTheme.colors.textPrimary,
                textAlign = TextAlign.Start,
                style = LeasingTheme.typography.titleLg
            )
        }
        CarImage(url = carDetails.imageUrl)
        CarNameText(name = carDetails.name)
        CarCharacteristics(
            transmission = carDetails.transmission,
            steering = carDetails.steering,
            bodyType = carDetails.bodyType,
            color = carDetails.color
        )
        RentTotal(carDetails.price, rentStart, rentEnd)
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                variant = ButtonVariant.Outline
            ) {
                Text(text = stringResource(R.string.car_details_back))
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.car_details_book))
            }
        }
    }
}

@Composable
private fun CarImage(url: String) {
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 16.dp)
    )
}

@Composable
private fun CarNameText(name: String) {
    Text(
        text = name,
        modifier = Modifier.padding(vertical = 16.dp),
        color = LeasingTheme.colors.textPrimary,
        style = LeasingTheme.typography.titleLg
    )
}

@Composable
private fun CarCharacteristics(
    transmission: String, steering: String, bodyType: String, color: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.car_details_characteristics),
            color = LeasingTheme.colors.textPrimary,
            style = LeasingTheme.typography.paragraphMediumM
        )
        CharacteristicRow(
            name = stringResource(R.string.car_details_transmission), value = transmission
        )
        Divider()
        CharacteristicRow(name = stringResource(R.string.car_details_steering), value = steering)
        Divider()
        CharacteristicRow(name = stringResource(R.string.car_details_body_type), value = bodyType)
        Divider()
        CharacteristicRow(name = stringResource(R.string.car_details_color), value = color)
    }
}

@Composable
private fun CharacteristicRow(
    name: String, value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            modifier = Modifier.weight(1f),
            color = LeasingTheme.colors.textTertiary,
            style = LeasingTheme.typography.paragraphRegularM
        )
        Text(
            text = value,
            modifier = Modifier.weight(1f),
            color = LeasingTheme.colors.textPrimary,
            style = LeasingTheme.typography.paragraphRegularM
        )
    }
}

@Composable
private fun RentTotal(price: Int, rentStart: Long, rentEnd: Long) {
    Column(
        modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.car_details_price),
            color = LeasingTheme.colors.textPrimary,
            style = LeasingTheme.typography.paragraphMediumM
        )
        Divider()
        Text(
            text = stringResource(
                R.string.car_details_total_pattern,
                price * maxOf(1, daysBetweenTimestamps(rentStart, rentEnd))
            ),
            color = LeasingTheme.colors.textPrimary,
            style = LeasingTheme.typography.titleMd
        )
        Text(
            text = stringResource(
                R.string.car_details_rent_dates_pattern,
                formatRentDuration(rentStart, rentEnd, LocalContext.current)
            ),
            color = LeasingTheme.colors.textSecondary,
            style = LeasingTheme.typography.paragraphRegularM
        )
    }
}