package streafy.leasingshift2025.shared.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BodyTypeModel {
    @SerialName("sedan") SEDAN,
    @SerialName("suv") SUV,
    @SerialName("coupe") COUPE,
    @SerialName("hatchback") HATCHBACK,
    @SerialName("cabriolet") CABRIOLET,
}