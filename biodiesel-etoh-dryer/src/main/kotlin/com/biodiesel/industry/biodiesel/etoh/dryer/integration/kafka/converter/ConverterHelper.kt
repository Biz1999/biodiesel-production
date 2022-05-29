package com.biodiesel.industry.biodiesel.etoh.dryer.integration.kafka.converter

import com.biodiesel.industry.biodiesel.etoh.dryer.model.request.EtohSupply
import com.google.gson.Gson

fun String.jsonToObject(): EtohSupply = Gson().fromJson(this, EtohSupply::class.java)