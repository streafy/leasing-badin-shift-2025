package streafy.leasingshift2025.shared.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ColorModel {
    @SerialName("black") BLACK,
    @SerialName("white") WHITE,
    @SerialName("red") RED,
    @SerialName("silver") SILVER,
    @SerialName("blue") BLUE,
    @SerialName("grey") GREY,
    @SerialName("orange") ORANGE,
}