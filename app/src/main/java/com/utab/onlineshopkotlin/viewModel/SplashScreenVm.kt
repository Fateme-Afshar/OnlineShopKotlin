package com.utab.onlineshopkotlin.viewModel

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.utab.onlineshopkotlin.data.CategoryRepository
import com.utab.onlineshopkotlin.data.ProductRepository
import com.utab.onlineshopkotlin.model.Category
import com.utab.onlineshopkotlin.model.Product
import com.utab.onlineshopkotlin.utils.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SplashScreenVm @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) : BaseVm() {
    private val stateEventCategory = SingleLiveEvent<State>()
    var hasInternet = true

    private fun categories(): LiveData<List<Category>> = liveData {
            categoryRepository.categories().catch {
                it.message
                stateEventCategory.setValue(State.ERROR)
            }.collect { categories ->
                emit(categories)
                stateEventCategory.setValue(State.SUCCESS)
            }
    }

    private fun bestProducts(): LiveData<List<Product>> = liveData {
        val map = keyMap(QueryParameters.RATE, QueryParameters.ORDER_DESC)

        productRepository.products(map).catch {
            it.message
            stateEventCategory.setValue(State.ERROR)
        }.collect { productList ->
            emit(productList)
            stateEventCategory.setValue(State.SUCCESS)
        }
    }

    private fun newestProducts(): LiveData<List<Product>> = liveData {
        val map = keyMap(QueryParameters.DATE, QueryParameters.ORDER_DESC)

        productRepository.products(map).catch {
            it.message
            stateEventCategory.setValue(State.ERROR)
        }.collect { productList ->
            emit(productList)
            stateEventCategory.setValue(State.SUCCESS)
        }
    }

    private fun specialProducts(): LiveData<List<Product>> = liveData {
        val map = NetworkUtils.mapKey().toMutableMap()
        map[QueryParameters.ON_SALE] = "true"

        productRepository.products(map).catch {
            it.message
            stateEventCategory.setValue(State.ERROR)
        }.collect { productList ->
            emit(productList)
            stateEventCategory.setValue(State.SUCCESS)
        }
    }

    private fun populateProduct(): LiveData<List<Product>> = liveData {
        val map = keyMap(QueryParameters.POPULARITY, QueryParameters.ORDER_DESC)

        productRepository.products(map).catch {
            it.message
            stateEventCategory.setValue(State.ERROR)
        }.collect { productList ->
            emit(productList)
            stateEventCategory.setValue(State.SUCCESS)
        }
    }

    fun receiveCategories(lifecycleOwner: LifecycleOwner) {
        stateEventCategory.setValue(State.LOADING)
        categories().observe(lifecycleOwner) { categories ->
            categoryRepository.saveCategories(categories)
        }
    }

    fun receiveBestProducts(lifecycleOwner: LifecycleOwner) {
        bestProducts().observe(lifecycleOwner) { productList ->
            Log.d(ProgramUtils.TAG, "Receiving best products \t size: ${productList.size}")
        }
    }

    fun receiveNewestProduct(lifecycleOwner: LifecycleOwner) {
        newestProducts().observe(lifecycleOwner) { productList ->
            Log.d(ProgramUtils.TAG, "Receiving newest products \t size: ${productList.size}")
        }
    }

    fun receiveSpecialProduct(lifecycleOwner: LifecycleOwner) {
        specialProducts().observe(lifecycleOwner) { productList ->
            Log.d(ProgramUtils.TAG, "Receiving special products \t size: ${productList.size}")
        }
    }

    fun receivePopulatedProduct(lifecycleOwner: LifecycleOwner) {
        populateProduct().observe(lifecycleOwner) { productList ->
            Log.d(ProgramUtils.TAG, "Receiving populated products \t size: ${productList.size}")
        }
    }

    private fun keyMap(orderByValue: String, orderValue: String): HashMap<String, String> {
        val map = NetworkUtils.mapKey() as HashMap<String, String>
        map[QueryParameters.ORDER_BY] = orderByValue
        map[QueryParameters.ORDER] = orderValue
        return map
    }

    fun stateEvent(): LiveData<State> = stateEventCategory
}