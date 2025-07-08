package streafy.leasingshift2025.features.cardetails.data

import streafy.leasingshift2025.features.cardetails.data.models.CarDetailsModel
import streafy.leasingshift2025.features.cardetails.domain.CarDetails
import streafy.leasingshift2025.shared.BuildConfig
import javax.inject.Inject

class CarDetailsModelConverter @Inject constructor() {

    fun convert(model: CarDetailsModel) = with(model) {
        CarDetails(
            id = id,
            name = name,
            transmission = transmission.toString(),
            steering = steering.toString(),
            bodyType = bodyType.toString(),
            color = color.toString(),
            price = price,
            imageUrl = "${BuildConfig.BASE_URL}${media.first().url}"
        )
    }
}