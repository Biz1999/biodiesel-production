package com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.client

import com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.request.DecanterRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.response.DecanterResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("decanterFeignClient", url = "\${biodiesel-decanter.url}")
interface DecanterClient {

    @PostMapping("/v1/supply", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun performSupplyDecanter(@RequestBody decanterRequest: DecanterRequest): DecanterResponse
}