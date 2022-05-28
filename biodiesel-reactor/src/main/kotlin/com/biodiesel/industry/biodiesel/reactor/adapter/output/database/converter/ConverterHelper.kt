package com.biodiesel.industry.biodiesel.reactor.adapter.output.database.converter

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.entity.ReactorEntity
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.EtohReactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.NaohReactor
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

fun Reactor.toEntity(): ReactorEntity = ReactorEntity(
    id = 0,
    status = this.status.name,
    amount = amount,
    oilAmount = oilAmount,
    naohAmount = naohAmount,
    etohAmount = etohAmount,
    oilSupplyTime = oilSupplyTime,
    etohSupplyTime = etohSupplyTime,
    naohSupplyTime = naohSupplyTime
)

fun Reactor.toOilEntity(amount: Double): ReactorEntity = ReactorEntity(
    id = 0,
    status = this.status.name,
    amount = this.amount + amount,
    oilAmount = oilAmount + amount,
    naohAmount = naohAmount,
    etohAmount = etohAmount,
    naohSupplyTime = naohSupplyTime,
    etohSupplyTime = etohSupplyTime,
    outputTime = outputTime
)

fun Reactor.toEtohEntity(amount: Double): ReactorEntity = ReactorEntity(
    id = 0,
    status = this.status.name,
    amount = this.amount + amount,
    oilAmount = oilAmount,
    naohAmount = naohAmount,
    etohAmount = etohAmount + amount,
    oilSupplyTime = oilSupplyTime,
    naohSupplyTime = naohSupplyTime,
    outputTime = outputTime
)

fun Reactor.toNaohEntity(amount: Double): ReactorEntity = ReactorEntity(
    id = 0,
    status = this.status.name,
    amount = this.amount + amount,
    oilAmount = oilAmount,
    naohAmount = naohAmount + amount,
    etohAmount = etohAmount,
    oilSupplyTime = oilSupplyTime,
    etohSupplyTime = etohSupplyTime,
    outputTime = outputTime
)

fun ReactorEntity.toOilDomain(): OilReactor = OilReactor(
    amount = amount,
    oilAmount = oilAmount,
    oilSupplyTime = oilSupplyTime
)

fun ReactorEntity.toEtohDomain(): EtohReactor = EtohReactor(
    amount = amount,
    etohAmount = etohAmount,
    etohSupplyTime = etohSupplyTime
)

fun ReactorEntity.toNaohDomain(): NaohReactor = NaohReactor(
    amount = amount,
    naohAmount = naohAmount,
    naohSupplyTime = naohSupplyTime
)