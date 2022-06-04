package com.biodiesel.industry.biodiesel.dryer.service.converter

import com.biodiesel.industry.biodiesel.dryer.model.Dryer
import com.biodiesel.industry.biodiesel.dryer.model.request.DryerOutput
import com.biodiesel.industry.biodiesel.dryer.model.request.DryerSupplyRequest
import com.google.gson.Gson

fun DryerSupplyRequest.toDomain(dryer: Dryer): Dryer = Dryer(
    amount = dryer.amount + amount,
    supplyTime = dryer.supplyTime,
    outputTime = dryer.outputTime
)

fun toRequest(outputAmount: Double, lostPercentage: Double): DryerOutput = DryerOutput(
    amount = outputAmount * (1 - lostPercentage)
)

fun DryerOutput.objectToJson(): String = Gson().toJson(this)