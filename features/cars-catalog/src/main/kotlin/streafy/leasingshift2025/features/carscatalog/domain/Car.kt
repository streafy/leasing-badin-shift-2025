package streafy.leasingshift2025.features.carscatalog.domain

data class Car(
    val id: String,
    val name: String,
    val price: Int,
    val transmission: String,
    val imageUrl: String
)