package com.biodiesel.industry.biodiesel.reactor.application.dto

import java.time.LocalDateTime

data class EtohReactor(
    val amount: Double,
    val etohAmount: Double,
    val etohSupplyTime: LocalDateTime
)
