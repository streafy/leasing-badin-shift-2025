package streafy.leasingshift2025.features.carscatalog.domain

data class Car(
    val id: String,
    val name: String,
    val price: Int,
    val transmission: String,
    val imageUrl: String
) {
    companion object {
        fun createMockData() = List(10) {
            Car(
                "$it",
                "Auto $it",
                1000,
                "automatic",
                imageUrl = "https://shift-intensive.ru/api/static/images/cars/volkswagen-polo/volkswagen-polo-cover.webp"
            )
        }
    }
}