package com.biodiesel.industry.biodiesel.reactor.application.service.converter

import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.OilReactor

fun OilReactor.toDomain(reactor: Reactor): Reactor = Reactor(
    amount = amount,
    oilAmount = oilAmount,
    returnedAmount = reactor.returnedAmount,
    etohAmount = reactor.etohAmount,
    naohAmount = reactor.naohAmount,
    etohSupplyTime = reactor.etohSupplyTime,
    naohSupplyTime = reactor.naohSupplyTime,
    oilSupplyTime = oilSupplyTime,
    outputTime = reactor.outputTime,
    status = reactor.status
)