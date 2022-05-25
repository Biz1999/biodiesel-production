package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api.NaohTankApi
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.NaohRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.NaohResponse
import org.springframework.web.bind.annotation.RestController

@RestController
class NaohTankController: NaohTankApi {

    override fun performNaohSupply(naohRequest: NaohRequest): NaohResponse {
        TODO("Not yet implemented")
    }
}