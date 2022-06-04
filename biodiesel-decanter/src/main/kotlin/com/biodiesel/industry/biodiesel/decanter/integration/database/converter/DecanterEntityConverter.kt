package com.biodiesel.industry.biodiesel.decanter.integration.database.converter

import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterResponse
import com.biodiesel.industry.biodiesel.decanter.integration.database.entity.DecanterEntity
import com.biodiesel.industry.biodiesel.decanter.models.DecanterTank
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter
import java.time.LocalDateTime

fun DecanterEntity.toDomain(): DecanterTank = DecanterTank (
    amount = amount,
    status = enumValueOf(status),
    supplyTime = supplyTime,
    outputTime = outputTime
        )

fun DecanterTank.toEntitySupply(amount: Double, capacity: Double): DecanterEntity = DecanterEntity(
    id = 0,
    status = if((this.amount + amount) < capacity)  DecanterTank.Status.AVAILABLE.name else DecanterTank.Status.UNAVAILABLE.name,
    amount = this.amount + amount,
    supplyTime = LocalDateTime.now(),
    outputTime = outputTime
)

fun DecanterTank.toEntityOutput(amount: Double, capacity: Double): DecanterEntity = DecanterEntity(
    id = 0,
    status = if((this.amount + amount) < capacity)  DecanterTank.Status.AVAILABLE.name else DecanterTank.Status.UNAVAILABLE.name,
    amount = this.amount + amount,
    supplyTime = supplyTime,
    outputTime = LocalDateTime.now()
)

fun DecanterTank.toResponse(): DecanterResponse = DecanterResponse(
    amount = amount,
    supplyTime = LocalDateTime.now()
)