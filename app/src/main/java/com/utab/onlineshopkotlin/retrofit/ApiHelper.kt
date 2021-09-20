package com.utab.onlineshopkotlin.retrofit

import com.utab.onlineshopkotlin.model.Category
import com.utab.onlineshopkotlin.model.Product
import dagger.Binds
import retrofit2.http.GET
import retrofit2.http.QueryMap
interface ApiHelper {

    @GET("products/categories?per_page=100")
    suspend fun categories(@QueryMap keysMap: Map<String,String>) : List<Category>

    @GET("products")
    suspend fun products(@QueryMap keysMap: Map<String,String>) : List<Product>
}