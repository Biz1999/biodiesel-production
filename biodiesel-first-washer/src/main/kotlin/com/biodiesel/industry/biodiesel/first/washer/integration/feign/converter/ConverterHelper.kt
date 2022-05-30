package com.biodiesel.industry.biodiesel.first.washer.integration.feign.converter

import com.biodiesel.industry.biodiesel.first.washer.model.request.SupplyRequest

fun toRequest(amount: Double): SupplyRequest = SupplyRequest(
    amount = amount
)