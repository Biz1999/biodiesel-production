package com.biodiesel.industry.biodiesel.glycerin.tank.integration.kafka.converter

import com.biodiesel.industry.biodiesel.glycerin.tank.model.request.GlycerinSupply
import com.google.gson.Gson

fun String.jsonToObject(): GlycerinSupply = Gson().fromJson(this, GlycerinSupply::class.java)