package streafy.leasingshift2025.navigation.featurerouter

import streafy.leasingshift2025.features.cardetails.navigation.CarDetailsRouter
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRoute
import streafy.leasingshift2025.navigation.GlobalRouter
import javax.inject.Inject

class CarDetailsRouterImpl @Inject constructor(
    private val globalRouter: GlobalRouter
) : CarDetailsRouter {

    override fun back() {
        globalRouter.open(CarsCatalogRoute)
    }
}