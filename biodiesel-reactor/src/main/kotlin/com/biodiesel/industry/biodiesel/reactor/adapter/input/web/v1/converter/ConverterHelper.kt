package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.EtohRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.NaohRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.OilRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.EtohResponse
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.NaohResponse
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.OilResponse
import com.biodiesel.industry.biodiesel.reactor.application.domain.EtohSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.NaohSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.OilSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor

fun OilRequest.toDomain(): OilSupply = OilSupply(
    amount = amount
)

fun EtohRequest.toDomain(): EtohSupply = EtohSupply(
    amount = amount
)

fun NaohRequest.toDomain(): NaohSupply = NaohSupply(
    amount = amount
)

fun Reactor.toOilResponse(): OilResponse = OilResponse(
    amount = amount,
    returnedAmount = returnedAmount,
    supplyTime = oilSupplyTime
)

fun Reactor.toEtohResponse(): EtohResponse = EtohResponse(
    amount = amount,
    returnedAmount = returnedAmount,
    supplyTime = etohSupplyTime
)

fun Reactor.toNaohResponse(): NaohResponse = NaohResponse(
    amount = amount,
    returnedAmount = returnedAmount,
    supplyTime = naohSupplyTime
)