package com.biodiesel.industry.biodiesel.first.washer.model.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "FirstWasher")
data class WasherEntity(
    @Id
    val id: Long? = null,
    val amount: Double,
    val emulsion: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now(),
    val outputTime: LocalDateTime = LocalDateTime.now()
)
