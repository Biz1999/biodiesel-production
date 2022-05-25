package com.biodiesel.industry.biodiesel.etoh.tank.integration.database.converter

import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.entity.EtohTankEntity
import com.biodiesel.industry.biodiesel.etoh.tank.models.EtohTank


fun EtohTank.toEntitySupply(amount: Double): EtohTankEntity = EtohTankEntity(
    id = 0,
    amount = this.amount + amount,
    outputTime = outputTime
)

fun EtohTank.toEntityOutput(amount: Double): EtohTankEntity = EtohTankEntity(
    id = 0,
    amount = this.amount + amount,
    supplyTime = supplyTime
)

fun EtohTankEntity.toDomain(): EtohTank = EtohTank(
    amount = amount,
    supplyTime = supplyTime,
    outputTime = outputTime
)