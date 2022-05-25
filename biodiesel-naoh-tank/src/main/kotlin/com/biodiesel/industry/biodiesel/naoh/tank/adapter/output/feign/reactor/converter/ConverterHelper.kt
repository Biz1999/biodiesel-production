package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.converter

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.request.SupplyRequest
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.response.SupplyResponse
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank
import com.biodiesel.industry.biodiesel.naoh.tank.application.dto.NaohTankReactor

fun NaohTank.toRequest(): SupplyRequest = SupplyRequest(
    amount = amount
)

fun SupplyResponse.toDomain(): NaohTankReactor = NaohTankReactor(
    amount = amount,
    supplyTime = supplyTime
)