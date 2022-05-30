package com.biodiesel.industry.biodiesel.etoh.tank.models

import java.time.LocalDateTime

data class EtohTank(
    val amount: Double,
    val supplyTime: LocalDateTime,
    val outputTime: LocalDateTime
)

data class TankSupplyResponse(
    val amount: Double,
    val outputTime: LocalDateTime
)

data class EtohSupply(
    val amount: Double
)

data class EtohResponse(
    val amount: Double,
    val returnedAmount: Double

)