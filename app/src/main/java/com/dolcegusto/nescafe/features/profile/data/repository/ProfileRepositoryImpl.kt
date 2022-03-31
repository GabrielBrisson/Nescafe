package com.dolcegusto.nescafe.features.profile.data.repository

import com.dolcegusto.nescafe.app.data.model.Product
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

    private val mockedProducts: List<Product> = listOf(
        Product("1","Citrus Honey Tea", 2 ),
        Product("2","Café Au Lait Vanilla", 2 ),
        Product("3","Café Caseiro", 3 ),
        Product("4","Lungo", 2 ),
        Product("5","Mochaccino Canela", 5 ),
        Product("6","Cappuccino", 5 ),
        Product("7","Chococino Alpino", 5 ),
        Product("8","Chococino", 3 ),
        Product("9","Chococino Caramel", 5 ),
        Product("10","Mocha", 3 ),
        Product("11","Nestea Limão", 3 )
    )

    private val mockedOrderList: List<Order> = listOf(
        Order(
            id = "1",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            shippingAndHandlingPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
            status = Enums.OrderStatus.WAITING_CREDIT_CARD_CONFIRMATION,
            productList = mockedProducts,
            trackNumber = "FR220327Y9XBN"
        ),
        Order(
            id = "2",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            shippingAndHandlingPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
            status = Enums.OrderStatus.SEPARATION_PROCESS,
            productList = mockedProducts,
            trackNumber = "FR220327Y9XBN"
        ),
        Order(
            id = "3",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            shippingAndHandlingPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
            status = Enums.OrderStatus.IN_TRANSIT,
            productList = mockedProducts,
            trackNumber = "FR220327Y9XBN"
        ),
        Order(
            id = "4",
            number = "BRR2982123",
            date = 1648227480000,
            subtotalPrice = BigDecimal("87.55"),
            shippingAndHandlingPrice = BigDecimal("12.60"),
            totalPrice = BigDecimal("100.15"),
            status = Enums.OrderStatus.SENT,
            productList = mockedProducts,
            trackNumber = "FR220327Y9XBN"
        )
    )

}
