package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.response

import java.time.LocalDateTime

data class SupplyResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)
