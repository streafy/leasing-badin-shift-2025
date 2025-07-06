package streafy.leasingshift2025.features.cardetails.domain

import javax.inject.Inject

class GetCarDetailsUseCase @Inject constructor(
    repository: CarDetailsRepository
) : suspend (String) -> CarDetails by repository::getCarDetails