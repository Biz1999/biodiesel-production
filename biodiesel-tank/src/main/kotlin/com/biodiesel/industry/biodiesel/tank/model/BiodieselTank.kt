package com.biodiesel.industry.biodiesel.tank.model

import java.time.LocalDateTime

data class BiodieselTank(
    val amount: Double,
    val supplyTime: LocalDateTime
)
