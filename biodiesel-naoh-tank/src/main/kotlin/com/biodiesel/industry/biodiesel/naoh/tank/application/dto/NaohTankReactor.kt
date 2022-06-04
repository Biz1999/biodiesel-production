package com.biodiesel.industry.biodiesel.naoh.tank.application.dto

import java.time.LocalDateTime

data class NaohTankReactor(
    val amount: Double,
    val supplyTime: LocalDateTime
)
