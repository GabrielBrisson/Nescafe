package com.dolcegusto.nescafe.features.profile.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.dolcegusto.nescafe.features.profile.data.repository.ProfileRepository

class ProfileViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    val orders = repository.getOrders()

}