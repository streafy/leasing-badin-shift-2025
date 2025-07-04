package streafy.leasingshift2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import streafy.leasingshift2025.navigation.GlobalRouter
import streafy.leasingshift2025.shared.LocalViewModelFactory
import streafy.leasingshift2025.shared.ViewModelFactory
import streafy.leasingshift2025.uikit.theme.LeasingTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var globalRouter: GlobalRouter

    private val component by lazy {
        (application as LeasingApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            globalRouter.setNavController(navController)

            CompositionLocalProvider(LocalViewModelFactory provides viewModelFactory) {
                LeasingTheme {
                    MainScreen(navController)
                }
            }
        }
    }
}