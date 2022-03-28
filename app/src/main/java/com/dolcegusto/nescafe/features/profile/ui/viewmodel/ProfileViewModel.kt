package com.dolcegusto.nescafe.features.profile.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.dolcegusto.nescafe.app.data.model.User
import com.dolcegusto.nescafe.app.data.repository.UserRepository
import com.dolcegusto.nescafe.features.profile.data.model.Order
import com.dolcegusto.nescafe.features.profile.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val userRepository: UserRepository
//    private val navController: NavController
) : ViewModel() {

    val user : User = userRepository.getUser()
    val orders: List<Order> = profileRepository.getOrders()

}