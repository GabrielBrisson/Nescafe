package com.dolcegusto.nescafe.app.data.repository

import com.dolcegusto.nescafe.app.data.model.User

class UserRepositoryImpl : UserRepository {

    override fun getUser(): User {
        return mockedUser
    }

    private val mockedUser =
        User(
            id = "1",
            fullName = "Jon Doe",
            fidelityPoints = 150
    )
}