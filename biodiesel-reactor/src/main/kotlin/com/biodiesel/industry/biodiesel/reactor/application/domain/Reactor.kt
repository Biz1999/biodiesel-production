package com.biodiesel.industry.biodiesel.reactor.application.domain

import java.time.LocalDateTime

data class Reactor(
    val amount: Double,

    var returnedAmount: Double = 0.0,

    val status: Status,

    val oilAmount: Double,

    val naohAmount: Double,

    val etohAmount: Double,

    val oilSupplyTime: LocalDateTime,

    val etohSupplyTime: LocalDateTime,

    val naohSupplyTime: LocalDateTime,

    val outputTime: LocalDateTime
){
    enum class Status {
        AVAILABLE, UNAVAILABLE
    }

}
