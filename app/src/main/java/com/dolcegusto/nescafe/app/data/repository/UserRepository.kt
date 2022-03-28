package com.dolcegusto.nescafe.app.data.repository

import com.dolcegusto.nescafe.app.data.model.User

interface UserRepository {

    fun getUser() : User
}