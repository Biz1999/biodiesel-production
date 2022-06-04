package com.biodiesel.industry.biodiesel.dryer.model.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Dryer")
data class DryerEntity(
    @Id
    val id: Long? = null,
    val amount: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now(),
    val outputTime: LocalDateTime = LocalDateTime.now()
)
