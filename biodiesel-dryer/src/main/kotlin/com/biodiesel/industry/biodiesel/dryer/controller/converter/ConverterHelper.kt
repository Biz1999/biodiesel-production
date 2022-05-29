package com.biodiesel.industry.biodiesel.dryer.controller.converter

import com.biodiesel.industry.biodiesel.dryer.model.Dryer
import com.biodiesel.industry.biodiesel.dryer.model.response.DryerSupplyResponse

fun Dryer.toResponse(): DryerSupplyResponse = DryerSupplyResponse(
    amount = amount,
    supplyTime = supplyTime
)