package com.utab.onlineshopkotlin.data

import com.utab.onlineshopkotlin.model.Category
import com.utab.onlineshopkotlin.retrofit.RetrofitInstance
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class BaseRepository @Inject constructor(private val retrofitInstance: RetrofitInstance) {
    protected val apiHelper=retrofitInstance.apiHelper()
    private val categories= arrayListOf<Category>()

    fun saveCategories(categories:List<Category>){
        this.categories.addAll(categories)
    }

    fun getCategories() : List<Category> = categories
}