package com.biodiesel.industry.biodiesel.tank.service.converter

import com.biodiesel.industry.biodiesel.tank.model.BiodieselTank
import com.biodiesel.industry.biodiesel.tank.model.request.BiodieselSupply

fun BiodieselSupply.toDomain(biodieselTank: BiodieselTank): BiodieselTank = BiodieselTank(
    amount = biodieselTank.amount + amount,
    supplyTime = biodieselTank.supplyTime
)