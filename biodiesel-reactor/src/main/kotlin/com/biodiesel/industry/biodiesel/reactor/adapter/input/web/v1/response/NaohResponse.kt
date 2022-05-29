package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response

import java.time.LocalDateTime

data class NaohResponse(
    val amount: Double,
    val returnedAmount: Double,
    val supplyTime: LocalDateTime
)
