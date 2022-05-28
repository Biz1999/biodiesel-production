package com.biodiesel.industry.biodiesel.reactor.application.dto

import java.time.LocalDateTime

data class NaohReactor(
    val amount: Double,
    val naohAmount: Double,
    val naohSupplyTime: LocalDateTime
)
