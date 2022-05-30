package com.biodiesel.industry.biodiesel.glycerin.tank.model.database.converter

import com.biodiesel.industry.biodiesel.glycerin.tank.model.GlycerinTank
import com.biodiesel.industry.biodiesel.glycerin.tank.model.entity.GlycerinTankEntity

fun GlycerinTank.toEntity(): GlycerinTankEntity = GlycerinTankEntity(
    id = 0,
    amount = amount
)

fun GlycerinTankEntity.toDomain(): GlycerinTank = GlycerinTank(
    amount = amount,
    supplyTime = supplyTime
)