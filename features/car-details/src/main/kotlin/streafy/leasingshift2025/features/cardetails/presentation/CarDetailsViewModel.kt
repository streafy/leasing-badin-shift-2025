package streafy.leasingshift2025.features.cardetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import streafy.leasingshift2025.features.cardetails.domain.GetCarDetailsUseCase
import streafy.leasingshift2025.features.cardetails.navigation.CarDetailsRouter
import javax.inject.Inject

class CarDetailsViewModel @Inject constructor(
    private val router: CarDetailsRouter,
    private val getCarDetailsUseCase: GetCarDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CarDetailsState>(CarDetailsState.Initial)
    val state: StateFlow<CarDetailsState> get() = _state

    private val handler = CoroutineExceptionHandler { _, exception ->
        _state.value = CarDetailsState.Error(message = exception.message ?: "")
    }

    fun getCar(id: String) {
        viewModelScope.launch(handler) {
            _state.value = CarDetailsState.Content(getCarDetailsUseCase(id))
        }
    }

    fun back() {
        router.back()
    }
}