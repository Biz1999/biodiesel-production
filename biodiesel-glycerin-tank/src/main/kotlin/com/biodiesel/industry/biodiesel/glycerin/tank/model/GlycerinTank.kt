package com.biodiesel.industry.biodiesel.glycerin.tank.model

import java.time.LocalDateTime

data class GlycerinTank(
    val amount: Double,
    val supplyTime: LocalDateTime
)
