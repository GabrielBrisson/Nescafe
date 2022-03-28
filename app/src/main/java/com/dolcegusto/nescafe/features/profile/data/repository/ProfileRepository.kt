package com.dolcegusto.nescafe.features.profile.data.repository

import com.dolcegusto.nescafe.features.profile.data.model.Order

interface ProfileRepository {

    fun getOrders() : List<Order>
}