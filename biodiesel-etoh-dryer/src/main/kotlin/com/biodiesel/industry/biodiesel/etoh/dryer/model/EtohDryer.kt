package com.biodiesel.industry.biodiesel.etoh.dryer.model

import java.time.LocalDateTime

data class EtohDryer(
    val amount: Double,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
)