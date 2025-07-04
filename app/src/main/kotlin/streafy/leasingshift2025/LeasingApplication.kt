package streafy.leasingshift2025

import android.app.Application
import streafy.leasingshift2025.di.DaggerApplicationComponent

class LeasingApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.create()
    }
}