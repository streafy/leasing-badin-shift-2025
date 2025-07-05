package streafy.leasingshift2025.features.carscatalog.data

import retrofit2.http.GET
import streafy.leasingshift2025.features.carscatalog.data.models.CarsCatalogResponse

interface CarsCatalogApi {

    @GET("cars/info")
    suspend fun getCarsCatalog(): CarsCatalogResponse
}