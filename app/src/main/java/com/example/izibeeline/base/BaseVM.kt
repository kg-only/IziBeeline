package com.example.izibeeline.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseVM: ViewModel() {

    val event = MutableLiveData<CoreEvent>()

    fun setIsLoading(loading: Boolean) {
        event.value = Event.Loading(loading)
    }

}