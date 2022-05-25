package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api.OilTankApi
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.OilRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.OilResponse
import org.springframework.web.bind.annotation.RestController

@RestController
class OilTankController: OilTankApi {

    override fun performOilSuppy(oilRequest: OilRequest): OilResponse {
        TODO("Not yet implemented")
    }
}