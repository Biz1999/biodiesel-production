package com.biodiesel.industry.biodiesel.decanter.integration.database.entity

import com.biodiesel.industry.biodiesel.decanter.models.DecanterTank
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "decanter")
@Entity
data class DecanterEntity(
    @Id
    val id: Long? = null,
    val status: String,
    val amount: Double,
    val supplyTime: LocalDateTime = LocalDateTime.now(),
    val outputTime: LocalDateTime = LocalDateTime.now()
)