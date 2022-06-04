package com.biodiesel.industry.biodiesel.decanter.controller.response

import java.time.LocalDateTime

data class DecanterResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)


data class DecanterRequest(
    val amount: Double
)