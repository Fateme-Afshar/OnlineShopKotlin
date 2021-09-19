package com.utab.onlineshopkotlin.data

import com.utab.onlineshopkotlin.model.Category
import com.utab.onlineshopkotlin.retrofit.RetrofitInstance
import com.utab.onlineshopkotlin.utils.NetworkUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val retrofitInstance: RetrofitInstance) :
    BaseRepository(retrofitInstance) {

    fun categories(): Flow<List<Category>> = flow {
        emit(apiHelper.categories(NetworkUtils.mapKey()))
    }
}