package com.biodiesel.industry.biodiesel.second.washer.controller.converter

import com.biodiesel.industry.biodiesel.second.washer.model.Washer
import com.biodiesel.industry.biodiesel.second.washer.model.response.SupplyResponse

fun Washer.toResponse(): SupplyResponse = SupplyResponse(
    amount = amount,
    supplyTime = supplyTime
)