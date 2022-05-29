package com.biodiesel.industry.biodiesel.dryer.integration.database.converter

import com.biodiesel.industry.biodiesel.dryer.model.Dryer
import com.biodiesel.industry.biodiesel.dryer.model.entity.DryerEntity

fun DryerEntity.toDomain(): Dryer = Dryer(
    amount = amount,
    supplyTime = supplyTime,
    outputTime = outputTime
)

fun Dryer.toEntitySupply(): DryerEntity = DryerEntity(
    id = 0,
    amount = amount,
    outputTime = outputTime
)

fun Dryer.toEntityOutput(amount: Double): DryerEntity = DryerEntity(
    id = 0,
    amount = this.amount - amount,
    supplyTime = supplyTime
)