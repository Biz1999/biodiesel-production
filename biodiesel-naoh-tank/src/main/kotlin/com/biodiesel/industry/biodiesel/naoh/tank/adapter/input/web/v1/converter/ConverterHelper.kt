package com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.converter

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response.NaohOutputTankResponse
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response.NaohSupplyTankResponse
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank

fun NaohTank.toTankSupplyResponse(): NaohSupplyTankResponse = NaohSupplyTankResponse(
    amount = amount,
    supplyTime = supplyTime
)

fun NaohTank.toTankOutputResponse(): NaohOutputTankResponse = NaohOutputTankResponse(
    amount = amount,
    outputTime = outputTime
)