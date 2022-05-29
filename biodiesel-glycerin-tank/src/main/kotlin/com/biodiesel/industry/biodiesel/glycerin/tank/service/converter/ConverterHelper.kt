package com.biodiesel.industry.biodiesel.glycerin.tank.service.converter

import com.biodiesel.industry.biodiesel.glycerin.tank.model.GlycerinTank
import com.biodiesel.industry.biodiesel.glycerin.tank.model.request.GlycerinSupply

fun GlycerinSupply.toDomain(glycerinTank: GlycerinTank): GlycerinTank = GlycerinTank(
    amount = glycerinTank.amount + amount,
    supplyTime = glycerinTank.supplyTime
)