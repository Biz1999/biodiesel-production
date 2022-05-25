package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.client

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.request.SupplyRequest
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.response.SupplyResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("reactorFeignClient", url = "\${biodiesel-reactor.url}")
interface ReactorClient {

    @PostMapping("/v1/supply/naoh", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createReactorSupply(@RequestBody reactorSupplyRequest: SupplyRequest): SupplyResponse
}