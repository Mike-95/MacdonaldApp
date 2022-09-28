package com.example.macdonaldapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>(0)
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>("")
    val flavor: LiveData<String> = _flavor

    private val _data = MutableLiveData<String>("")
    val data: LiveData<String> = _data

    private val _price = MutableLiveData<Double>(0.0)
    val price: LiveData<Double> = _price

    // Methods
    fun setQuantity(numberBurgers: Int) {
        _quantity.value = numberBurgers
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setData(pickupDate: String) {
        _data.value = pickupDate
    }


}