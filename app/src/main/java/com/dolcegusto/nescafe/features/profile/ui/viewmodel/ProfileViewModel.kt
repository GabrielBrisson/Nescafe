package com.dolcegusto.nescafe.features.profile.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.dolcegusto.nescafe.features.profile.data.model.Order
import com.dolcegusto.nescafe.features.profile.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository,
//    private val navController: NavController
) : ViewModel() {

    val orders: List<Order> = repository.getOrders()

}