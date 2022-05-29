package com.biodiesel.industry.biodiesel.naoh.tank.application.domain

import java.time.LocalDateTime

data class NaohTank(
    val amount: Double,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
)
