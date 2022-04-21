package com.dolcegusto.nescafe.features.assemblebox.data.model

data class BoxCapsule(
    val id: String? = null,
    val name: String,
    val image: String? = null,
    val drinkQuantity: Int,
    val capsuleQuantity: Int
)
