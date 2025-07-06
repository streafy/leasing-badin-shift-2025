package streafy.leasingshift2025.features.cardetails.navigation

import kotlinx.serialization.Serializable
import streafy.leasingshift2025.shared.navigation.Screen

@Serializable
data class CarDetailsRoute(
    val id: String,
    val rentStart: Long,
    val rentEnd: Long
) : Screen
