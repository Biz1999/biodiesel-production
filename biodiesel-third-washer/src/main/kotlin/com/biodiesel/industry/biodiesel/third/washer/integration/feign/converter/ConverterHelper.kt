package com.biodiesel.industry.biodiesel.third.washer.integration.feign.converter

import com.biodiesel.industry.biodiesel.third.washer.model.request.SupplyRequest

fun toRequest(amount: Double): SupplyRequest = SupplyRequest(
    amount = amount
)