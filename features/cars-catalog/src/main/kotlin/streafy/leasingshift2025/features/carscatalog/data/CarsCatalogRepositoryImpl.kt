package streafy.leasingshift2025.features.carscatalog.data

import streafy.leasingshift2025.features.carscatalog.domain.Car
import streafy.leasingshift2025.features.carscatalog.domain.CarsCatalogRepository
import javax.inject.Inject

class CarsCatalogRepositoryImpl @Inject constructor(
    private val api: CarsCatalogApi,
    private val converter: CarModelConverter
) : CarsCatalogRepository {

    override suspend fun getCarsCatalog(): List<Car> {
        return api.getCarsCatalog().data.map(converter::convert)
    }
}