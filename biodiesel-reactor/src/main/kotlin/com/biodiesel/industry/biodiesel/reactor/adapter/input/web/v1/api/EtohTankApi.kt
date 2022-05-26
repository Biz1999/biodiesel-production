package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.EtohRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.EtohResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/v1")
interface EtohTankApi {

    @PostMapping("/supply/etoh")
    @ResponseStatus(HttpStatus.CREATED)
    fun performEtohSupply(@RequestBody etohRequest: EtohRequest): EtohResponse
}