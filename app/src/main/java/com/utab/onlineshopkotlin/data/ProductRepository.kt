package com.utab.onlineshopkotlin.data

import com.utab.onlineshopkotlin.model.Product
import com.utab.onlineshopkotlin.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(retrofitInstance: RetrofitInstance) :
    BaseRepository(retrofitInstance) {

        fun products(queryMap: Map<String,String>) : Flow<List<Product>> = flow {
            emit(apiHelper.products(queryMap))
        }
}