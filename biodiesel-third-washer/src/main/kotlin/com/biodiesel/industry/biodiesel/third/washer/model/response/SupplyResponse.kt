package com.biodiesel.industry.biodiesel.third.washer.model.response

import java.time.LocalDateTime

data class SupplyResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)
