package streafy.leasingshift2025.features.carscatalog.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import streafy.leasingshift2025.features.carscatalog.data.CarsCatalogApi
import streafy.leasingshift2025.features.carscatalog.data.CarsCatalogRepositoryImpl
import streafy.leasingshift2025.features.carscatalog.domain.CarsCatalogRepository
import streafy.leasingshift2025.shared.di.ApplicationScope

@Module
interface CarsCatalogModule {

    companion object {
        @ApplicationScope
        @Provides
        fun provideCarsCatalogApi(retrofit: Retrofit): CarsCatalogApi = retrofit.create()
    }

    @ApplicationScope
    @Binds
    fun bindCarsCatalogRepository(impl: CarsCatalogRepositoryImpl): CarsCatalogRepository
}