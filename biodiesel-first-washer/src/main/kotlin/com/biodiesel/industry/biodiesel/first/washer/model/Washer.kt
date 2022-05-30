package com.biodiesel.industry.biodiesel.first.washer.model

import java.time.LocalDateTime

data class Washer(
    val amount: Double,
    val emulsion: Double,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
)
