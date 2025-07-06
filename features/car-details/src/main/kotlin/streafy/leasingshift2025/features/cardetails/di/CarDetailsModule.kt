package streafy.leasingshift2025.features.cardetails.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import streafy.leasingshift2025.features.cardetails.data.CarDetailsApi
import streafy.leasingshift2025.features.cardetails.data.CarDetailsRepositoryImpl
import streafy.leasingshift2025.features.cardetails.domain.CarDetailsRepository
import streafy.leasingshift2025.shared.di.ApplicationScope

@Module
interface CarDetailsModule {

    companion object {
        @ApplicationScope
        @Provides
        fun provideCarDetailsApi(retrofit: Retrofit): CarDetailsApi = retrofit.create()
    }

    @ApplicationScope
    @Binds
    fun bindCarDetailsRepository(impl: CarDetailsRepositoryImpl): CarDetailsRepository
}