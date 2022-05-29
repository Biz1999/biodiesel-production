package com.biodiesel.industry.biodiesel.reactor.adapter.output.database.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "Reactor")
@Entity
data class ReactorEntity(
    @Id
    val id: Long? = null,
    val status: String,
    val amount: Double,
    val oilAmount: Double,
    val naohAmount: Double,
    val etohAmount: Double,
    val oilSupplyTime: LocalDateTime = LocalDateTime.now(),
    val etohSupplyTime: LocalDateTime = LocalDateTime.now(),
    val naohSupplyTime: LocalDateTime = LocalDateTime.now(),
    val outputTime: LocalDateTime = LocalDateTime.now()
)