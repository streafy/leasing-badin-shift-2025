package streafy.leasingshift2025.features.cardetails.presentation

import streafy.leasingshift2025.features.cardetails.domain.CarDetails

sealed interface CarDetailsState {

    data object Initial : CarDetailsState

    data object Loading : CarDetailsState

    data class Error(val message: String) : CarDetailsState

    data class Content(val carDetails: CarDetails) : CarDetailsState
}