package com.example.macdonaldapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    private val _price = MutableLiveData<Double>()
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

    init {
        resetOrder()
    }

    // Checking if the flavor for  order has been set or not
    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    // Creating list of pickup dates
    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    val dateOptions = getPickupOptions()

    // reset Mutable Live data properties
    private fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
     //  _data.value = dateOptions[1]
        _price.value = 0.0
    }
}