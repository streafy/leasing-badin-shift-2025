package streafy.leasingshift2025.navigation.featurerouter

import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogFiltersRoute
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRouter
import streafy.leasingshift2025.navigation.GlobalRouter

class CarsCatalogRouterImpl(
    private val router: GlobalRouter
) : CarsCatalogRouter {

    override fun openCarsCatalogFilters() {
        router.open(CarsCatalogFiltersRoute)
    }
}