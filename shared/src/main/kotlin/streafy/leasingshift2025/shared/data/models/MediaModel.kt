package streafy.leasingshift2025.shared.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaModel(
    @SerialName("url") val url: String,
    @SerialName("isCover") val isCover: Boolean,
)