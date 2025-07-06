package streafy.leasingshift2025.features.carscatalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import streafy.leasingshift2025.features.carscatalog.domain.GetCarsCatalogUseCase
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRouter
import javax.inject.Inject

class CarsCatalogViewModel @Inject constructor(
    private val router: CarsCatalogRouter,
    private val getCarsCatalogUseCase: GetCarsCatalogUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<CarsCatalogState>(CarsCatalogState.Initial)
    val state: StateFlow<CarsCatalogState> get() = _state

    private val handler = CoroutineExceptionHandler { _, exception ->
        _state.value = CarsCatalogState.Error(message = exception.message ?: "")
    }

    fun getCarsCatalog() {
        viewModelScope.launch(handler) {
            _state.value = CarsCatalogState.Content(getCarsCatalogUseCase())
        }
    }

    fun openCarCard(id: String) {
        val now = System.currentTimeMillis()
        val afterTenDays = now + 86400000 * 10
        router.openCarDetails(id, now, afterTenDays)
    }

    fun openFiltersScreen() {
        router.openCarsCatalogFilters()
    }
}