package com.biodiesel.industry.biodiesel.second.washer.integration.feign.converter

import com.biodiesel.industry.biodiesel.second.washer.model.request.SupplyRequest

fun toRequest(amount: Double): SupplyRequest = SupplyRequest(
    amount = amount
)