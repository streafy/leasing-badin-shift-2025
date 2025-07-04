package streafy.leasingshift2025.features.carscatalog.presentation

import androidx.lifecycle.ViewModel
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRouter
import javax.inject.Inject

class CarsCatalogViewModel @Inject constructor(
    private val router: CarsCatalogRouter
) : ViewModel() {

    fun openCarCard(id: String) {
        //TODO
    }

    fun openFiltersScreen() {
        router.openCarsCatalogFilters()
    }
}