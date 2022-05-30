package com.biodiesel.industry.biodiesel.third.washer.controller.converter

import com.biodiesel.industry.biodiesel.third.washer.model.Washer
import com.biodiesel.industry.biodiesel.third.washer.model.response.SupplyResponse

fun Washer.toResponse(): SupplyResponse = SupplyResponse(
    amount = amount,
    supplyTime = supplyTime
)