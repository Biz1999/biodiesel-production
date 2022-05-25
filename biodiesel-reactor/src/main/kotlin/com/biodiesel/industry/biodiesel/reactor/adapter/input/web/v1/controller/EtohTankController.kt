package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api.EtohTankApi
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.EtohRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.EtohResponse
import org.springframework.web.bind.annotation.RestController

@RestController
class EtohTankController: EtohTankApi {

    override fun performEtohSupply(etohRequest: EtohRequest): EtohResponse {
        TODO("Not yet implemented")
    }
}