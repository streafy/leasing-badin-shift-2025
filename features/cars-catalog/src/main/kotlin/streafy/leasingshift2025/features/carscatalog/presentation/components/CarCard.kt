package streafy.leasingshift2025.features.carscatalog.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import streafy.leasingshift2025.features.carscatalog.R
import streafy.leasingshift2025.features.carscatalog.domain.Car
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun CarCard(
    car: Car,
    onCarClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(116.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple()
            ) { onCarClicked(car.id.toInt()) }
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = car.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .width(152.dp)
                .height(116.dp)
                .weight(1f)
        )
        Spacer(Modifier.width(24.dp))
        CarInfo(car = car)
    }
}

@Composable
fun RowScope.CarInfo(car: Car, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .weight(1f)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = car.name,
                color = LeasingTheme.colors.textPrimary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = LeasingTheme.typography.paragraphMediumM
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = car.transmission,
                color = LeasingTheme.colors.textSecondary,
                style = LeasingTheme.typography.paragraphRegularXS
            )
        }
        Column {
            Text(
                text = stringResource(R.string.car_card_price_pattern, car.price),
                color = LeasingTheme.colors.textPrimary,
                style = LeasingTheme.typography.paragraphMediumM
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = stringResource(R.string.car_card_price_for_14_days_pattern, car.price * 14),
                color = LeasingTheme.colors.textSecondary,
                style = LeasingTheme.typography.paragraphRegularXS
            )
        }
    }
}