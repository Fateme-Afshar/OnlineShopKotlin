package com.utab.onlineshopkotlin.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.utab.onlineshopkotlin.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
class RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        initRetrofit()
    }

    private fun initRetrofit(): Retrofit {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().baseUrl(NetworkUtils.BASE_URL).addConverterFactory(
            MoshiConverterFactory.create(moshi)
        ).build()
    }

    @Provides
    fun apiHelper() : ApiHelper{
        return retrofit.create(ApiHelper::class.java)
    }
}

