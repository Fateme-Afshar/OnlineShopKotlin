package com.utab.onlineshopkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.utab.onlineshopkotlin.R
import com.utab.onlineshopkotlin.databinding.FragmentSplashScreenBinding
import com.utab.onlineshopkotlin.utils.State
import com.utab.onlineshopkotlin.viewModel.SplashScreenVm
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenFragment : BaseFragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    @Inject
    lateinit var splashVm: SplashScreenVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashVm.receiveCategories(this)
        splashVm.receiveBestProducts(this)
        splashVm.receiveNewestProduct(this)
        splashVm.receivePopulatedProduct(this)
        splashVm.receiveSpecialProduct(this)

        splashVm.stateEvent().observe(this) { state ->
            if (state == State.ERROR) {
                showSnackBar(binding.root, "خطایی در دریافت اطلاعات به وجود آمده است")
                splashVm.hasInternet=false
                checkInternetSetup()
                splashVm.stateEvent().removeObservers(this)
            }
        }
    }

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
        if (hasInternet()) {
            setupVisibility(View.VISIBLE, View.GONE)
        } else
            setupVisibility(View.GONE, View.VISIBLE)
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
