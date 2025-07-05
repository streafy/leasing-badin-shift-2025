package streafy.leasingshift2025.features.carscatalog.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BrandModel {
    @SerialName("Haval") HAVAL,
    @SerialName("Hyundai") HYUNDAI,
    @SerialName("Volkswagen") VOLKSWAGEN,
    @SerialName("Kia") KIA,
    @SerialName("Geely") GEELY,
    @SerialName("Mercedes") MERCEDES,
    @SerialName("Garden car") GARDEN_CAR,
    @SerialName("Grocery cart") GROCERY_CART,
    @SerialName("Haier") HAIER,
    @SerialName("Invalid") INVALID,
}