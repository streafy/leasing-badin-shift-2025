package streafy.leasingshift2025.features.cardetails.domain

data class CarDetails(
    val id: String,
    val name: String,
    val transmission: String,
    val steering: String,
    val bodyType: String,
    val color: String,
    val price: Int,
    val imageUrl: String
)
