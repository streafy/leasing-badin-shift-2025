package streafy.leasingshift2025.features.cardetails.data

import retrofit2.http.GET
import retrofit2.http.Path
import streafy.leasingshift2025.features.cardetails.data.models.CarDetailsResponse

interface CarDetailsApi {

    @GET("cars/info/{carId}")
    suspend fun getCarDetails(@Path("carId") carId: String): CarDetailsResponse
}