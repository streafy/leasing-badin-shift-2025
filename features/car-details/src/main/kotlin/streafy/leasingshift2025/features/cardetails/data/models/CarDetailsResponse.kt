package streafy.leasingshift2025.features.cardetails.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CarDetailsResponse(
    @SerialName("success") val success: Boolean,
    @SerialName("reason") val reason: String? = null,
    @SerialName("data") val data: CarDetailsModel,
)