package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.converter

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.request.SupplyRequest
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.response.SupplyResponse
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank
import com.biodiesel.industry.biodiesel.naoh.tank.application.dto.NaohTankReactor

fun toRequest(amount: Double): SupplyRequest = SupplyRequest(
    amount = amount
)

fun SupplyResponse.toDomain(): NaohTankReactor = NaohTankReactor(
    amount = returnedAmount,
    supplyTime = supplyTime
)