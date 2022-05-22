package com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response

import java.time.LocalDateTime

data class TankOutputResponse(
    val amount: Double,
    val outputTime: LocalDateTime
)
