package streafy.leasingshift2025.features.carscatalog.domain

interface CarsCatalogRepository {

    suspend fun getCarsCatalog(): List<Car>
}