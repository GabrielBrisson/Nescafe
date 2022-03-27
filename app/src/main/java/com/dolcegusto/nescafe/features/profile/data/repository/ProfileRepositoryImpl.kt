package com.dolcegusto.nescafe.features.profile.data.repository

import com.dolcegusto.nescafe.app.util.Enums
import com.dolcegusto.nescafe.features.profile.data.model.Order
import java.math.BigDecimal
import java.util.*

class ProfileRepositoryImpl : ProfileRepository{

    override fun getOrders(): List<Order> {
        return mockedOrderList
    }

    companion object {
        val mockedOrderList: List<Order> = listOf(
            Order(
                id = "1",
                number = "BRR2982123",
                date = Date(1648227480000),
                subtotalPrice = BigDecimal("87,55"),
                extraPrice = BigDecimal("12,60"),
                totalPrice = BigDecimal("100,15"),
                status = Enums.OrderStatus.SEPARATION_PROCESS,
                productList = listOf(
                    "Citrus Honey Tea",
                    "Café Au Lait Vanilla",
                    "Café Caseiro",
                    "Lungo",
                    "Mochaccino Canela",
                    "Cappuccino",
                    "Chococino Alpino",
                    "Chococino",
                    "Chococino Caramel",
                    "Mocha",
                    "Nestea Limão"
                )
            )
        )
    }
}
