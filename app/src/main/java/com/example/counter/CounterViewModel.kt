package com.example.counter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() { //view model type

    private val _counter = MutableLiveData<Int>() //mutable = can change, is a live data (data will occur on the spot change)

    val counter : LiveData<Int>
        get() = _counter

    init{
        Log.d("ViewModel", "ViewModel Initialised")
        _counter.value = 0
    }

    fun increment(){
        _counter.value = _counter.value?.plus(1)
    }

    fun decrement(){
        _counter.value = _counter.value?.minus(1)

    }


    //when app reach the time, after being destroy, system will call onCleared automatically
    override fun onCleared() {
        Log.d("ViewModel", "ViewModelCleared")
        super.onCleared()
    }





}