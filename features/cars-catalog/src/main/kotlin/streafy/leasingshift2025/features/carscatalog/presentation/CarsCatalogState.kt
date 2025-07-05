package streafy.leasingshift2025.features.carscatalog.presentation

import streafy.leasingshift2025.features.carscatalog.domain.Car

sealed interface CarsCatalogState {

    data object Initial : CarsCatalogState

    data object Loading : CarsCatalogState

    data class Error(val message: String) : CarsCatalogState

    data class Content(val cars: List<Car>) : CarsCatalogState
}