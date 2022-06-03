package com.biodiesel.industry.biodiesel.decanter.models

import java.time.LocalDateTime

data class DecanterTank(
    val amount: Double,
    val status: Status,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
) {
        enum class Status {
            AVAILABLE, UNAVAILABLE
        }
    }