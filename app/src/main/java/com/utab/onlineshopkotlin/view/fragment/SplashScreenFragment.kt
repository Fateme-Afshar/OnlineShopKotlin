package com.utab.onlineshopkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.utab.onlineshopkotlin.R
import com.utab.onlineshopkotlin.databinding.FragmentSplashScreenBinding
import javax.inject.Inject

class SplashScreenFragment : BaseFragment() {
    private lateinit var binding: FragmentSplashScreenBinding
    @Inject
    lateinit var splashVm:SplashScreenFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false)
        return binding.root
    }
}