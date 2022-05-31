package com.biodiesel.industry.biodiesel.first.washer.model.response

import java.time.LocalDateTime

data class SupplyResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)
