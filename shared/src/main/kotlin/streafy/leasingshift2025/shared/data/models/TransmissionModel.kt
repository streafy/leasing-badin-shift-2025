package streafy.leasingshift2025.shared.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TransmissionModel {
    @SerialName("automatic") AUTOMATIC,
    @SerialName("manual") MANUAL,
}