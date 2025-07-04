package streafy.leasingshift2025.navigation

import androidx.navigation.NavHostController
import streafy.leasingshift2025.shared.navigation.Screen
import javax.inject.Inject

class GlobalRouterImpl @Inject constructor() : GlobalRouter {

    private var navController: NavHostController? = null

    override fun setNavController(controller: NavHostController) {
        navController = controller
    }

    override fun clearNavController() {
        navController = null
    }

    override fun open(screen: Screen) {
        navController?.navigate(screen)
    }

    override fun openAsRoot(screen: Screen) {
        navController?.navigate(screen) {
            navController?.graph?.id?.let {
                popUpTo(it) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }

    override fun pop() {
        navController?.popBackStack()
    }
}