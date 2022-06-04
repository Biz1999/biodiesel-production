package com.biodiesel.industry.biodiesel.tank.integration.kafka.converter

import com.biodiesel.industry.biodiesel.tank.model.request.BiodieselSupply
import com.google.gson.Gson

fun String.jsonToObject(): BiodieselSupply = Gson().fromJson(this, BiodieselSupply::class.java)