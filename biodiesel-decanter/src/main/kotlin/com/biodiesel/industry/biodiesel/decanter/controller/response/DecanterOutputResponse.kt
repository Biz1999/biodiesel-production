package com.biodiesel.industry.biodiesel.decanter.controller.response

import com.google.gson.Gson
import java.time.LocalDateTime

data class DecanterOutputRequest(
    val amount: Double,
)

data class DecanterOutputResponse(
    val amount: Double,
    val supplyTime: LocalDateTime
)

fun DecanterOutputRequest.objectToJson(): String = Gson().toJson(this)