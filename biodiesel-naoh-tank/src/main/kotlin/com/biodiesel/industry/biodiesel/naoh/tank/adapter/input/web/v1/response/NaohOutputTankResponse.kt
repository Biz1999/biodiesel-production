package com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response

import java.time.LocalDateTime

data class NaohOutputTankResponse(
    val amount: Double,
    val outputTime: LocalDateTime
)
