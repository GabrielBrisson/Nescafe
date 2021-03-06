package com.dolcegusto.nescafe.features.profile.data.model

import com.dolcegusto.nescafe.app.data.model.Product
import com.dolcegusto.nescafe.app.util.Enums
import java.io.Serializable
import java.math.BigDecimal
import java.util.Date

data class Order(
    val id : String,
    val number: String,
    val date: Long,
    val subtotalPrice: BigDecimal,
    val shippingAndHandlingPrice: BigDecimal,
    val totalPrice: BigDecimal,
    val status : Enums.OrderStatus,
    val productList: List<Product>,
    val trackNumber: String?
) : Serializable
