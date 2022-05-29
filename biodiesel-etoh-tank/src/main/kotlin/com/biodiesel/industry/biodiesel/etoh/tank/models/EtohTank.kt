package com.biodiesel.industry.biodiesel.etoh.tank.models

import java.time.LocalDateTime

data class EtohTank(
    val amount: Double,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
)
