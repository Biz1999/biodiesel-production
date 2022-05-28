package com.biodiesel.industry.biodiesel.reactor.application.service.converter

import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.EtohReactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.NaohReactor
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

fun EtohReactor.toDomain(reactor: Reactor): Reactor = Reactor(
    amount = amount,
    oilAmount = reactor.oilAmount,
    returnedAmount = reactor.returnedAmount,
    etohAmount = etohAmount,
    naohAmount = reactor.naohAmount,
    etohSupplyTime = etohSupplyTime,
    naohSupplyTime = reactor.naohSupplyTime,
    oilSupplyTime = reactor.oilSupplyTime,
    outputTime = reactor.outputTime,
    status = reactor.status
)

fun NaohReactor.toDomain(reactor: Reactor): Reactor = Reactor(
    amount = amount,
    oilAmount = reactor.oilAmount,
    returnedAmount = reactor.returnedAmount,
    etohAmount = reactor.etohAmount,
    naohAmount = naohAmount,
    etohSupplyTime = reactor.etohSupplyTime,
    naohSupplyTime = naohSupplyTime,
    oilSupplyTime = reactor.oilSupplyTime,
    outputTime = reactor.outputTime,
    status = reactor.status
)