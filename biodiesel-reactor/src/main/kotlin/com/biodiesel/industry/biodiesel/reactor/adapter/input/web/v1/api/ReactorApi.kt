package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1")
interface ReactorApi {

    @PostMapping("/start")
    fun performProcessing(): ResponseEntity<*>
}