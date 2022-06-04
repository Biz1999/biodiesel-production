package com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response

import java.time.LocalDateTime

data class NaohSupplyTankResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)
