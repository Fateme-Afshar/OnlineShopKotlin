package com.utab.onlineshopkotlin.viewModel

import androidx.lifecycle.ViewModel
import com.utab.onlineshopkotlin.utils.SingleLiveEvent
import javax.inject.Inject

open class BaseVm @Inject constructor() : ViewModel(){
    private var hasInternet=SingleLiveEvent<Boolean>()


}