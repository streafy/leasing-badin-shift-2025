package streafy.leasingshift2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import streafy.leasingshift2025.uikit.components.Button
import streafy.leasingshift2025.uikit.components.ButtonVariant
import streafy.leasingshift2025.uikit.components.Input
import streafy.leasingshift2025.uikit.theme.LeasingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            LeasingTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = LeasingTheme.colors.bgPrimary
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(0.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Input(label = "Поиск", placeholder = "Поиск")
                        Input(label = "Даты аренды", placeholder = "10 - 24 июля 2025 (14 дней)")
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(0.8f),
                            variant = ButtonVariant.PrimaryDark
                        ) {
                            Text(text = "Фильтры")
                        }
                    }
                }
            }
        }
    }
}