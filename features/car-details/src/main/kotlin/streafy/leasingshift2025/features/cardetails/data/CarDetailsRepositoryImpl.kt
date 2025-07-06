package streafy.leasingshift2025.features.cardetails.data

import streafy.leasingshift2025.features.cardetails.domain.CarDetails
import streafy.leasingshift2025.features.cardetails.domain.CarDetailsRepository
import javax.inject.Inject

class CarDetailsRepositoryImpl @Inject constructor(
    private val api: CarDetailsApi,
    private val converter: CarDetailsModelConverter
) : CarDetailsRepository {

    override suspend fun getCarDetails(id: String): CarDetails =
        converter.convert(api.getCarDetails(id).data)
}