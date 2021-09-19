package com.utab.onlineshopkotlin.view.fragment

import android.net.ConnectivityManager
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.utab.onlineshopkotlin.utils.NetworkUtils

open class BaseFragment : Fragment() {

    fun showSnackBar(view: View,msg:String) {
        Snackbar.make(view,msg,Snackbar.LENGTH_SHORT).show()
    }

    fun hasInternet(): Boolean {
        return NetworkUtils.checkNetworkConnectivity(
            requireActivity().getSystemService(
                ConnectivityManager::class.java
            )
        )
    }

}