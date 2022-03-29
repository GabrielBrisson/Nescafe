package com.dolcegusto.nescafe.features.profile.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.dolcegusto.nescafe.features.profile.data.model.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor() : ViewModel() {

    private var _order: Order? = null

    fun getOrder() = _order

    fun setOrder(value: Order){
        _order = value
    }
}