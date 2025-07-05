package streafy.leasingshift2025.di

import dagger.Component
import streafy.leasingshift2025.MainActivity
import streafy.leasingshift2025.features.carscatalog.di.CarsCatalogModule
import streafy.leasingshift2025.shared.di.ApplicationScope

@ApplicationScope
@Component(modules = [NavigationModule::class, ViewModelModule::class, NetworkModule::class, CarsCatalogModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}