package streafy.leasingshift2025.features.carscatalog.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SteeringModel {
    @SerialName("left") LEFT,
    @SerialName("right") RIGHT,
}