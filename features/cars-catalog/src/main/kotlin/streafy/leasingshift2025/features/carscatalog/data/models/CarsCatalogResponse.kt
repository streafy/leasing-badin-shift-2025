package streafy.leasingshift2025.features.carscatalog.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CarsCatalogResponse(
    @SerialName("success") val success: Boolean,
    @SerialName("reason") val reason: String? = null,
    @SerialName("data") val data: List<CarModel>,
    @SerialName("meta") val meta: PaginationMeta,
)