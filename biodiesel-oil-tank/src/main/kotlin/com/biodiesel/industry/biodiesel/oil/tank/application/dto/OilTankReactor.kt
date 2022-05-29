package com.biodiesel.industry.biodiesel.oil.tank.application.dto

import java.time.LocalDateTime

data class OilTankReactor(
    val amount: Double,
    val supplyTime: LocalDateTime
)
