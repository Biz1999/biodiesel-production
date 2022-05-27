package com.biodiesel.industry.biodiesel.reactor.application.dto

import java.time.LocalDateTime

data class OilReactor(
    val oilAmount: Double,
    val oilSupplyTime: LocalDateTime
)
