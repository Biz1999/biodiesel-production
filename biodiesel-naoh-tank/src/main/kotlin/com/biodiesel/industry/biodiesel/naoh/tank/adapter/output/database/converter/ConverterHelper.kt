package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.converter

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.entity.NaohTankEntity
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank

fun NaohTank.toEntitySupply(amount: Double): NaohTankEntity = NaohTankEntity(
    id = 0,
    amount = this.amount + amount,
    outputTime = outputTime
)

fun NaohTank.toEntityOutput(amount: Double): NaohTankEntity = NaohTankEntity(
    id = 0,
    amount = this.amount + amount,
    supplyTime = supplyTime
)

fun NaohTankEntity.toDomain(): NaohTank = NaohTank(
    amount = amount,
    supplyTime = supplyTime,
    outputTime = outputTime
)