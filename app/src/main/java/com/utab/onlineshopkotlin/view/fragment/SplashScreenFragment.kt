package com.utab.onlineshopkotlin.view.fragment

import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.utab.onlineshopkotlin.R
import com.utab.onlineshopkotlin.databinding.FragmentSplashScreenBinding
import com.utab.onlineshopkotlin.utils.NetworkUtils
import javax.inject.Inject

class SplashScreenFragment : BaseFragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    @Inject
    lateinit var splashVm: SplashScreenFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false)
        binding.fragment = this
        checkInternetSetup()
        return binding.root
    }

    fun checkInternetSetup() {
        activity?.let { activity ->
            if (NetworkUtils.checkNetworkConnectivity(activity.getSystemService(ConnectivityManager::class.java)))
                setupVisibility(View.VISIBLE, View.GONE)
            else
                setupVisibility(View.GONE, View.VISIBLE)
        }
    }

    private fun setupVisibility(hasInternetVisibility: Int, noInternetVisibility: Int) {
        binding.animNoInternet.visibility = noInternetVisibility
        binding.tvNoInternet.visibility = noInternetVisibility
        binding.btnRefresh.visibility = noInternetVisibility

        binding.animLoading.visibility = hasInternetVisibility
        binding.tvOnlineShop.visibility = hasInternetVisibility
        binding.tvOnlineShopEn.visibility = hasInternetVisibility
        binding.imvOnlineMarket.visibility=hasInternetVisibility
    }
}
