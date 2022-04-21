package com.dolcegusto.nescafe.features.assemblebox.data.model

data class SavedBox(
    val id: String? = null,
    val name: String,
    val capsules: List<BoxCapsule>
)
