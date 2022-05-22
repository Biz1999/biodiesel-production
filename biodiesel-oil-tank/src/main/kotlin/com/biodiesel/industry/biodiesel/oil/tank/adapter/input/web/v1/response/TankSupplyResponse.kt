package com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

data class TankSupplyResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)
