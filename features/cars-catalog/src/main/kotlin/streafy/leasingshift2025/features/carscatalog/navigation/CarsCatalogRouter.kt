package streafy.leasingshift2025.features.carscatalog.navigation

interface CarsCatalogRouter {

    fun openCarDetails(id: String, rentStart: Long, rentEnd: Long)

    fun openCarsCatalogFilters()
}