package com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.helper

import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response.TankOutputResponse
import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response.TankSupplyResponse
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank

fun OilTank.toTankSupplyResponse(): TankSupplyResponse = TankSupplyResponse(
    amount = amount,
    supplyTime = supplyTime
)

fun OilTank.toTankOutputResponse(): TankOutputResponse = TankOutputResponse(
    amount = amount,
    outputTime = outputTime
)