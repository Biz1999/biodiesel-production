package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.NaohRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.NaohResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/v1")
interface NaohTankApi {

    @PostMapping("/supply/naoh")
    @ResponseStatus(HttpStatus.CREATED)
    fun performNaohSupply(@RequestBody naohRequest: NaohRequest): ResponseEntity<*>
}