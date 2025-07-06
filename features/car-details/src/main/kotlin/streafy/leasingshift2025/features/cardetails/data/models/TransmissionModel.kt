package streafy.leasingshift2025.features.cardetails.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TransmissionModel {
    @SerialName("automatic") AUTOMATIC,
    @SerialName("manual") MANUAL,
}