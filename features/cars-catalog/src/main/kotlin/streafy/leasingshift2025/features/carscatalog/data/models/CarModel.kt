package streafy.leasingshift2025.features.carscatalog.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import streafy.leasingshift2025.shared.data.models.BodyTypeModel
import streafy.leasingshift2025.shared.data.models.BrandModel
import streafy.leasingshift2025.shared.data.models.ColorModel
import streafy.leasingshift2025.shared.data.models.MediaModel
import streafy.leasingshift2025.shared.data.models.SteeringModel
import streafy.leasingshift2025.shared.data.models.TransmissionModel

@Serializable
data class CarModel(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("brand") val brand: BrandModel,
    @SerialName("media") val media: List<MediaModel>,
    @SerialName("transmission") val transmission: TransmissionModel,
    @SerialName("price") val price: Int,
    @SerialName("location") val location: String,
    @SerialName("color") val color: ColorModel,
    @SerialName("bodyType") val bodyType: BodyTypeModel,
    @SerialName("steering") val steering: SteeringModel,
)