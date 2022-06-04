package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.entity

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "NaohTank")
@Entity
data class NaohTankEntity(
    @Id
    val id: Long? = null,
    val amount: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now(),
    val outputTime: LocalDateTime = LocalDateTime.now()
)
