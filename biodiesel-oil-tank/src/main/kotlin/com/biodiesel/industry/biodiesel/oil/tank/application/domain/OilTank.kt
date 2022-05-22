package com.biodiesel.industry.biodiesel.oil.tank.application.domain

import java.time.LocalDateTime

data class OilTank(
    val amount: Double,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
)
