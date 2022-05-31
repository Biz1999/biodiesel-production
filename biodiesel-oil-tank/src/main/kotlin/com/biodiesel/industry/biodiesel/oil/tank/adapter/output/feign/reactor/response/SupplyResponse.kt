package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.response

import java.time.LocalDateTime

data class SupplyResponse(
    val amount: Double,
    val returnedAmount: Double,
    val supplyTime: LocalDateTime
)
