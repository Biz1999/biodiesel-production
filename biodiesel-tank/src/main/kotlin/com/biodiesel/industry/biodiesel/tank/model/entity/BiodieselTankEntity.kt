package com.biodiesel.industry.biodiesel.tank.model.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "BiodieselTank")
data class BiodieselTankEntity(
    @Id
    val id: Long? = null,
    val amount: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now()
)