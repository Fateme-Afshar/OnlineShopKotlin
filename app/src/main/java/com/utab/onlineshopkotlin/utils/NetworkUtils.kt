package com.utab.onlineshopkotlin.utils

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData

class NetworkUtils {
    companion object{
        const val BASE_URL="https://woocommerce.maktabsharif.ir/wp-json/wc/v3/"

        fun mapKey():Map<String,String>{
            val map= mutableMapOf<String,String>()
            map["consumer_key"]="ck_373d2b7f68efab7ceba67788d017dfcc8e80cab6"
            map["consumer_secret"]="cs_45ceb9de983308785f5affc3b5648a48101b4b67"

            return map
        }

        @RequiresApi(Build.VERSION_CODES.M)
        fun checkNetworkConnectivity(connectivityManager: ConnectivityManager): Boolean {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i(ProgramUtils.TAG, "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                    Log.i(ProgramUtils.TAG, "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)){
                    Log.i(ProgramUtils.TAG, "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
            Log.i(ProgramUtils.TAG, "NetworkCapabilities is null")
            return false
        }
    }
}