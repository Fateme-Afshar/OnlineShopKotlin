package com.utab.onlineshopkotlin.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class  SingleLiveEvent<T> : MutableLiveData<T>() {
    private val atomicBoolean=AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t ->
            if (atomicBoolean.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    override fun setValue(value: T) {
        atomicBoolean.set(true)
        super.setValue(value)
    }
}