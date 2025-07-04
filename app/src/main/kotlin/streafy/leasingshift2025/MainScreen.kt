package streafy.leasingshift2025

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogFiltersRoute
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRoute
import streafy.leasingshift2025.features.carscatalog.presentation.screens.CarsCatalogFiltersScreen
import streafy.leasingshift2025.features.carscatalog.presentation.screens.CarsCatalogScreen
import streafy.leasingshift2025.navigation.GlobalRouter
import streafy.leasingshift2025.navigation.GlobalRouterImpl
import streafy.leasingshift2025.navigation.featurerouter.CarsCatalogRouterImpl
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val globalRouter: GlobalRouter = GlobalRouterImpl()
    globalRouter.setNavController(navController)
    val carsCatalogRouterImpl = CarsCatalogRouterImpl(globalRouter)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = LeasingTheme.colors.bgPrimary
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = CarsCatalogRoute,
        ) {
            composable<CarsCatalogRoute> {
                CarsCatalogScreen(
                    onFiltersButtonClick = { carsCatalogRouterImpl.openCarsCatalogFilters() },
                    onCarCardClick = {}
                )
            }
            composable<CarsCatalogFiltersRoute> {
                CarsCatalogFiltersScreen()
            }
        }
    }
}