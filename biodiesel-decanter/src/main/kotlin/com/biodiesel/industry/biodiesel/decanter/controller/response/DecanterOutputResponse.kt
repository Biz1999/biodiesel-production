package com.biodiesel.industry.biodiesel.decanter.controller.response

import java.time.LocalDateTime

data class TankOutputResponse(
    val amount: Double,
    val outputTime: LocalDateTime
)