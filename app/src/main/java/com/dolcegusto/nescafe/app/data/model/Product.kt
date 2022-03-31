package com.dolcegusto.nescafe.app.data.model

import java.io.Serializable

data class Product(
    val id: String,
    val name: String,
    val quantity: Int
) : Serializable
