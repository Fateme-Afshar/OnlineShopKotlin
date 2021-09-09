package com.utab.onlineshopkotlin.data

import com.utab.onlineshopkotlin.retrofit.RetrofitInstance
import javax.inject.Inject

open class BaseRepository @Inject constructor(private val retrofitInstance: RetrofitInstance?) {
    protected val apiHelper=retrofitInstance?.apiHelper()
}