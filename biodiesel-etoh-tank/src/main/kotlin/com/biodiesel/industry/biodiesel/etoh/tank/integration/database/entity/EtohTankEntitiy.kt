package com.biodiesel.industry.biodiesel.etoh.tank.integration.database.entity

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "EtohTank")
@Entity
data class EtohTankEntity(
    @Id
    var id: Long? = null,
    val amount: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now(),
    val outputTime: LocalDateTime = LocalDateTime.now()
)
