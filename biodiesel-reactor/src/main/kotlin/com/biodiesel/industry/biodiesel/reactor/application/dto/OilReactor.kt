package com.biodiesel.industry.biodiesel.reactor.application.dto

import java.time.LocalDateTime

data class OilReactor(
    val amount: Double,
    val oilAmount: Double,
    val oilSupplyTime: LocalDateTime
)
