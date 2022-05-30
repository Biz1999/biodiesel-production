package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.converter

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.request.SupplyRequest
import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.response.SupplyResponse
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank
import com.biodiesel.industry.biodiesel.oil.tank.application.dto.OilTankReactor


fun OilTank.toRequest(amount: Double): SupplyRequest = SupplyRequest(
    amount = amount
)

fun SupplyResponse.toDomain(): OilTankReactor = OilTankReactor(
    amount = returnedAmount,
    supplyTime = supplyTime
)