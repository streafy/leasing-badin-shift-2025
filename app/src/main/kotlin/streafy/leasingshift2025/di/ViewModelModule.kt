package streafy.leasingshift2025.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import streafy.leasingshift2025.features.cardetails.presentation.CarDetailsViewModel
import streafy.leasingshift2025.features.carscatalog.presentation.CarsCatalogViewModel
import streafy.leasingshift2025.shared.di.ViewModelKey

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(CarsCatalogViewModel::class)
    @Binds
    fun bindCarsCatalogViewModel(impl: CarsCatalogViewModel): ViewModel

    @IntoMap
    @ViewModelKey(CarDetailsViewModel::class)
    @Binds
    fun bindCarDetailsViewModel(impl: CarDetailsViewModel): ViewModel
}