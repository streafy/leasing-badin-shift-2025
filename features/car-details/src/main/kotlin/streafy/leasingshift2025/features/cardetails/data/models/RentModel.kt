package streafy.leasingshift2025.features.cardetails.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RentModel(
    @SerialName("startDate") val startDate: Long,
    @SerialName("endDate") val endDate: Long,
)