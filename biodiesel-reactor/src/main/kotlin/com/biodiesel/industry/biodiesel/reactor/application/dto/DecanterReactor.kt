package com.biodiesel.industry.biodiesel.reactor.application.dto

import java.time.LocalDateTime

data class DecanterReactor(
    val amount: Double,
    val oilAmount: Double,
    val etohAmount: Double,
    val naohAmount: Double,
    val supplyTime: LocalDateTime
)
