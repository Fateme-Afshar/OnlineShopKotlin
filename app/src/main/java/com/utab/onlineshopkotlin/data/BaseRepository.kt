package com.utab.onlineshopkotlin.data

import com.utab.onlineshopkotlin.model.Category
import com.utab.onlineshopkotlin.model.Product
import com.utab.onlineshopkotlin.retrofit.RetrofitInstance
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class BaseRepository @Inject constructor(private val retrofitInstance: RetrofitInstance) {
    protected val apiHelper=retrofitInstance.apiHelper()
    private val categories= arrayListOf<Category>()
    private val bestProducts= arrayListOf<Product>()
    private val populateProducts= arrayListOf<Product>()
    private val newestProducts= arrayListOf<Product>()
    private val specialProducts= arrayListOf<Product>()

    fun saveCategories(categories:List<Category>){
        this.categories.addAll(categories)
    }

    fun getCategories() : List<Category> = categories
    fun bestProducts() : List<Product> = bestProducts
    fun populateProducts() : List<Product> =populateProducts
    fun newestProducts() : List<Product> =newestProducts
    fun specialProducts() :List<Product> = specialProducts
}