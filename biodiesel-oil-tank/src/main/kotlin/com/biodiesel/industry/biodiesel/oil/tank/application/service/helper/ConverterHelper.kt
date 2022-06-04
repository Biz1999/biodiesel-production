package com.biodiesel.industry.biodiesel.oil.tank.application.service.helper

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.entity.OilTankEntity
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank

fun OilTankEntity.toDomain(): OilTank = OilTank(
    amount = amount,
    supplyTime = supplyTime,
    outputTime = outputTime
)