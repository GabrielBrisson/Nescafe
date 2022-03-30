package com.dolcegusto.nescafe.features.profile.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.dolcegusto.nescafe.app.data.model.Product
import com.dolcegusto.nescafe.features.profile.data.model.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderDetailsViewModel @Inject constructor() : ViewModel() {

    private lateinit var _order: Order
    private lateinit var _products: List<Product>

    fun getOrder() = _order

    fun setOrder(value: Order) {
        _order = value
    }

    fun getProducts(): List<Product> = _order.productList

}