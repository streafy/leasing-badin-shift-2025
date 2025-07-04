package streafy.leasingshift2025.navigation

import androidx.navigation.NavHostController
import streafy.leasingshift2025.shared.navigation.Screen

interface GlobalRouter {

    fun setNavController(controller: NavHostController)

    fun clearNavController()

    fun open(screen: Screen)

    fun openAsRoot(screen: Screen)

    fun pop()
}