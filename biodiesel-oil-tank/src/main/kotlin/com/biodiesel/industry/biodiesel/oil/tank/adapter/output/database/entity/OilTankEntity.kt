package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.entity

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "OilTank")
@Entity
data class OilTankEntity(
    @Id
    var id: Long? = null,
    val amount: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now(),
    val outputTime: LocalDateTime = LocalDateTime.now()
)
