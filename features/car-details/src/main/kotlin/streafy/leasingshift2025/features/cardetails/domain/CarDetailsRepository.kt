package streafy.leasingshift2025.features.cardetails.domain

interface CarDetailsRepository {

    suspend fun getCarDetails(id: String): CarDetails
}