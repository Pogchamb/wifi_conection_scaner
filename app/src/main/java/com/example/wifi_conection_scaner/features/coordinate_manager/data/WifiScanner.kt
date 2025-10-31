package com.example.wifi_conection_scaner.features.coordinate_manager.data

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi

class WifiScanner(private val context: Context) {

    private val connectivityManager =
        context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @RequiresApi(Build.VERSION_CODES.Q)
    fun getCurrentRssi(): Int {
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        val rssi = capabilities?.signalStrength

        return rssi ?: -100
    }
}