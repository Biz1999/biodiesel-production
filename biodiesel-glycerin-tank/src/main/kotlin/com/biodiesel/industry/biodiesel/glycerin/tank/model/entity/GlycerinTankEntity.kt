package com.biodiesel.industry.biodiesel.glycerin.tank.model.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "GlycerinTank")
data class GlycerinTankEntity(
    @Id
    val id: Long? = null,
    val amount: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now()
)
