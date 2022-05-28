package com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.response

import java.time.LocalDateTime

data class DecanterResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)
