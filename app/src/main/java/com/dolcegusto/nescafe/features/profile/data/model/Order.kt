package com.dolcegusto.nescafe.features.profile.data.model

import com.dolcegusto.nescafe.app.util.Enums
import java.io.Serializable
import java.math.BigDecimal
import java.util.Date

data class Order(
    val id : String,
    val number: String,
    val date: Long,
    val subtotalPrice: BigDecimal,
    val extraPrice: BigDecimal,
    val totalPrice: BigDecimal,
    val status : Enums.OrderStatus,
    val productList: List<String>,
    val trackNumber: String
) : Serializable
