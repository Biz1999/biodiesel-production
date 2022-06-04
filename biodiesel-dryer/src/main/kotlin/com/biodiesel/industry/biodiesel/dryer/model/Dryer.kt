package com.biodiesel.industry.biodiesel.dryer.model

import java.time.LocalDateTime

data class Dryer(
    val amount: Double,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
)