package com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.converter

import com.biodiesel.industry.biodiesel.etoh.dryer.model.EtohDryer
import com.biodiesel.industry.biodiesel.etoh.dryer.model.entity.EtohDryerEntity

fun EtohDryerEntity.toDomain(): EtohDryer = EtohDryer(
    amount = amount,
    supplyTime = supplyTime,
    outputTime = outputTime
)

fun EtohDryer.toEntitySupply(): EtohDryerEntity = EtohDryerEntity(
    id = 0,
    amount = amount,
    outputTime = outputTime
)

fun EtohDryer.toEntityOutput(amount: Double): EtohDryerEntity = EtohDryerEntity(
    id = 0,
    amount = this.amount - amount,
    supplyTime = supplyTime
)