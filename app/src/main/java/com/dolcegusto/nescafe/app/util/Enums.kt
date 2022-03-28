package com.dolcegusto.nescafe.app.util

class Enums {

    enum class OrderStatus(val value : String) {
        WAITING_CREDIT_CARD_CONFIRMATION("waiting_credit_card_confirmation"),
        SEPARATION_PROCESS("separation_process"),
        IN_TRANSIT("in_transit"),
        SENT("sent")
    }
}