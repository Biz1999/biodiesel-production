package com.biodiesel.industry.biodiesel.dryer.model.response

import java.time.LocalDateTime

data class DryerSupplyResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)
