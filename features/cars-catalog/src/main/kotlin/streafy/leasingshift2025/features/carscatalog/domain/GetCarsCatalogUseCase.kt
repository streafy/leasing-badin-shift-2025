package streafy.leasingshift2025.features.carscatalog.domain

import javax.inject.Inject

class GetCarsCatalogUseCase @Inject constructor(
    repository: CarsCatalogRepository
): suspend () -> List<Car> by repository::getCarsCatalog