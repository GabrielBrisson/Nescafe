package com.dolcegusto.nescafe.app.util

import java.text.SimpleDateFormat
import java.util.*

fun Long.toDateFormat(): String {
    val date = Date(this)
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return dateFormat.format(date)
}