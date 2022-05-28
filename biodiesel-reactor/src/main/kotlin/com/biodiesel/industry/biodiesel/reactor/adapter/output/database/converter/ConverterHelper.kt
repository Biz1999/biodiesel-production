package com.biodiesel.industry.biodiesel.reactor.adapter.output.database.converter

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.entity.ReactorEntity
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.OilReactor

fun ReactorEntity.toDomain(): Reactor = Reactor(
    amount = amount,
    status = enumValueOf(status),
    oilAmount = oilAmount,
    etohAmount = etohAmount,
    naohAmount = naohAmount,
    oilSupplyTime = oilSupplyTime,
    etohSupplyTime = etohSupplyTime,
    naohSupplyTime = naohSupplyTime,
    outputTime = outputTime
)

fun Reactor.toOilEntity(amount: Double): ReactorEntity = ReactorEntity(
    id = 0,
    status = this.status.name,
    amount = this.amount + amount,
    oilAmount = oilAmount + amount,
    naohAmount = naohAmount,
    etohAmount = etohAmount,
    naohSupplyTime = naohSupplyTime,
    etohSupplyTime = etohSupplyTime
)

fun ReactorEntity.toOilDomain(): OilReactor = OilReactor(
    amount = amount,
    oilAmount = oilAmount,
    oilSupplyTime = oilSupplyTime
)