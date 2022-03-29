package com.dolcegusto.nescafe.features.profile.data.repository

import com.dolcegusto.nescafe.app.util.Enums
import com.dolcegusto.nescafe.features.profile.data.model.Order
import java.math.BigDecimal
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(): ProfileRepository {

    override fun getOrders(): List<Order> {
        return mockedOrderList
    }

    override fun findOrderById(id: String): Order? {
        return mockedOrderList.find { it.id == id }
    }

    private val mockedOrderList: List<Order> = listOf(
        Order(
            id = "1",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            extraPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
            status = Enums.OrderStatus.WAITING_CREDIT_CARD_CONFIRMATION,
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
            ),
            trackNumber = "FR220327Y9XBN"
        ),
        Order(
            id = "2",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            extraPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
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
            ),
            trackNumber = "FR220327Y9XBN"
        ),
        Order(
            id = "3",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            extraPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
            status = Enums.OrderStatus.IN_TRANSIT,
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
            ),
            trackNumber = "FR220327Y9XBN"
        ),
        Order(
            id = "4",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            extraPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
            status = Enums.OrderStatus.SENT,
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
            ),
            trackNumber = "FR220327Y9XBN"
        )
    )

}
