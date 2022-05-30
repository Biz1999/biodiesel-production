package com.biodiesel.industry.biodiesel.first.washer.controller.converter

import com.biodiesel.industry.biodiesel.first.washer.model.Washer
import com.biodiesel.industry.biodiesel.first.washer.model.response.SupplyResponse

fun Washer.toResponse(): SupplyResponse = SupplyResponse(
    amount = amount,
    supplyTime = supplyTime
)