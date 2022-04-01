package com.dolcegusto.nescafe.app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dolcegusto.nescafe.app.data.model.Product
import com.dolcegusto.nescafe.app.util.Enums
import com.dolcegusto.nescafe.features.profile.data.model.Order
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeeAllViewModel @Inject constructor(
) : ViewModel() {

    private var _contentType = MutableLiveData<Enums.SeeAllContentType>()
    private var _orderList = MutableLiveData<List<Order>>()

    fun setType(value: Enums.SeeAllContentType) {
       _contentType.value = value
    }

    fun getContentType() : Enums.SeeAllContentType? {
        return _contentType.value
    }

    fun setContent(list: List<*>) {
        when (_contentType.value) {
            Enums.SeeAllContentType.ORDER -> {
                _orderList.value = list.filterIsInstance<Order>()
            }

            else -> Unit
        }
    }

    fun getOrderList() = _orderList
}