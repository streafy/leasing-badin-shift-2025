package streafy.leasingshift2025.navigation.featurerouter

import streafy.leasingshift2025.features.cardetails.navigation.CarDetailsRoute
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogFiltersRoute
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRouter
import streafy.leasingshift2025.navigation.GlobalRouter
import javax.inject.Inject

class CarsCatalogRouterImpl @Inject constructor(
    private val router: GlobalRouter
) : CarsCatalogRouter {

    override fun openCarDetails(id: String, rentStart: Long, rentEnd: Long) {
        router.open(CarDetailsRoute(id, rentStart, rentEnd))
    }

    override fun openCarsCatalogFilters() {
        router.open(CarsCatalogFiltersRoute)
    }
}