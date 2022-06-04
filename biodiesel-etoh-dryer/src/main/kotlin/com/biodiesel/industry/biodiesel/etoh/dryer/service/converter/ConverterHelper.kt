package com.biodiesel.industry.biodiesel.etoh.dryer.service.converter

import com.biodiesel.industry.biodiesel.etoh.dryer.model.EtohDryer
import com.biodiesel.industry.biodiesel.etoh.dryer.model.request.EtohOutput
import com.biodiesel.industry.biodiesel.etoh.dryer.model.request.EtohSupply
import com.google.gson.Gson

fun EtohSupply.toDomain(etohDryer: EtohDryer): EtohDryer = EtohDryer(
    amount = etohDryer.amount + amount,
    supplyTime = etohDryer.supplyTime,
    outputTime = etohDryer.outputTime
)

fun toRequest(outputAmount: Double, lostPercentage: Double): EtohOutput = EtohOutput(
    amount = outputAmount * (1 - lostPercentage)
)

fun EtohOutput.objectToJson(): String = Gson().toJson(this)