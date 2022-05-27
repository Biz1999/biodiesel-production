package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.OilRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.OilResponse
import com.biodiesel.industry.biodiesel.reactor.application.domain.OilSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor

fun OilRequest.toDomain(): OilSupply = OilSupply(
    amount = amount
)


fun Reactor.toOilResponse(): OilResponse = OilResponse(
    amount = amount,
    returnedAmount = returnedAmount,
    supplyTime = oilSupplyTime
)