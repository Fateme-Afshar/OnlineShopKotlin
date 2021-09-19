package com.utab.onlineshopkotlin.viewModel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.utab.onlineshopkotlin.data.CategoryRepository
import com.utab.onlineshopkotlin.model.Category
import com.utab.onlineshopkotlin.utils.SingleLiveEvent
import com.utab.onlineshopkotlin.utils.State
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SplashScreenVm @Inject constructor(private val categoryRepository: CategoryRepository) : BaseVm() {
    private val stateEvent=SingleLiveEvent<State>()

    private fun categories() : LiveData<List<Category>> = liveData {
        categoryRepository.categories().catch {
            stateEvent.setValue(State.ERROR)
        }.collect { categories->
            emit(categories)
            stateEvent.setValue(State.SUCCESS)
        }
    }

    fun receiveCategories(lifecycleOwner: LifecycleOwner){
        stateEvent.setValue(State.LOADING)
        categories().observe(lifecycleOwner){categories->
            categoryRepository.saveCategories(categories)
        }
    }

    fun stateEvent() : LiveData<State> = stateEvent
}