package streafy.leasingshift2025.di

import dagger.Binds
import dagger.Module
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRouter
import streafy.leasingshift2025.navigation.GlobalRouter
import streafy.leasingshift2025.navigation.GlobalRouterImpl
import streafy.leasingshift2025.navigation.featurerouter.CarsCatalogRouterImpl
import streafy.leasingshift2025.shared.di.ApplicationScope

@Module
interface NavigationModule {

    @ApplicationScope
    @Binds
    fun bindGlobalRouter(impl: GlobalRouterImpl): GlobalRouter

    @ApplicationScope
    @Binds
    fun bindCarsCatalogRouter(impl: CarsCatalogRouterImpl): CarsCatalogRouter
}