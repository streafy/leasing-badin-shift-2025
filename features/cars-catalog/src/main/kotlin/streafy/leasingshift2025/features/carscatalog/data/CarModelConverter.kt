package streafy.leasingshift2025.features.carscatalog.data

import streafy.leasingshift2025.features.carscatalog.data.models.CarModel
import streafy.leasingshift2025.features.carscatalog.domain.Car
import streafy.leasingshift2025.shared.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class CarModelConverter @Inject constructor() {

    fun convert(model: CarModel) = with(model) {
        Car(
            id = id,
            name = name,
            price = price,
            transmission = transmission.toString(),
            imageUrl = "https://shift-intensive.ru/api${media.first().url}"
        )
    }
}