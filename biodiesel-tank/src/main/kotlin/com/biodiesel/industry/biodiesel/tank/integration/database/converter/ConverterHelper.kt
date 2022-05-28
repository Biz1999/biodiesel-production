package com.biodiesel.industry.biodiesel.tank.integration.database.converter

import com.biodiesel.industry.biodiesel.tank.model.BiodieselTank
import com.biodiesel.industry.biodiesel.tank.model.entity.BiodieselTankEntity

fun BiodieselTank.toEntity(): BiodieselTankEntity = BiodieselTankEntity(
    id = 0,
    amount = amount
)

fun BiodieselTankEntity.toDomain(): BiodieselTank = BiodieselTank(
    amount = amount,
    supplyTime = supplyTime
)