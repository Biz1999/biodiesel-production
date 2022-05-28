package com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.converter

import com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.request.DecanterRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.response.DecanterResponse
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.DecanterReactor

fun toRequest(amount: Double): DecanterRequest = DecanterRequest(
    amount = amount
)

fun DecanterResponse.toDomain(reactor: Reactor, outputAmount: Double): DecanterReactor = DecanterReactor(
    amount = reactor.amount - outputAmount,
    oilAmount = reactor.oilAmount - (outputAmount / 2),
    etohAmount = reactor.etohAmount - (outputAmount / 4),
    naohAmount = reactor.naohAmount - (outputAmount / 4),
    supplyTime = supplyTime
)