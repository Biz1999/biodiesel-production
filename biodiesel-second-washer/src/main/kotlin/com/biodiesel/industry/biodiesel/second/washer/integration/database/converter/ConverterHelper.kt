package com.biodiesel.industry.biodiesel.second.washer.integration.database.converter

import com.biodiesel.industry.biodiesel.second.washer.model.Washer
import com.biodiesel.industry.biodiesel.second.washer.model.entity.WasherEntity

fun WasherEntity.toDomain(): Washer = Washer(
    amount = amount,
    emulsion = emulsion,
    supplyTime = supplyTime,
    outputTime = outputTime
)

fun Washer.toEntity(amount: Double, emulsion: Double): WasherEntity = WasherEntity(
    id = 0,
    amount = this.amount + amount,
    emulsion = this.emulsion + emulsion,
    supplyTime = supplyTime
)