package streafy.leasingshift2025

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import streafy.leasingshift2025.features.cardetails.presentation.CarDetailsScreen
import streafy.leasingshift2025.features.cardetails.navigation.CarDetailsRoute
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogFiltersRoute
import streafy.leasingshift2025.features.carscatalog.navigation.CarsCatalogRoute
import streafy.leasingshift2025.features.carscatalog.presentation.screens.CarsCatalogFiltersScreen
import streafy.leasingshift2025.features.carscatalog.presentation.screens.CarsCatalogScreen
import streafy.leasingshift2025.uikit.theme.LeasingTheme

@Composable
fun MainScreen(
    navController: NavHostController
) {
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
                CarsCatalogScreen()
            }
            composable<CarsCatalogFiltersRoute> {
                CarsCatalogFiltersScreen()
            }
            composable<CarDetailsRoute> {
                val destination = it.toRoute<CarDetailsRoute>()

                CarDetailsScreen(destination.id, destination.rentStart, destination.rentEnd)
            }
        }
    }
}