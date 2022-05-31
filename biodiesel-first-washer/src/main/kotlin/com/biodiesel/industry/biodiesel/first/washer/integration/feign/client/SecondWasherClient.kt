package com.biodiesel.industry.biodiesel.first.washer.integration.feign.client

import com.biodiesel.industry.biodiesel.first.washer.model.request.SupplyRequest
import com.biodiesel.industry.biodiesel.first.washer.model.response.SupplyResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("secondWasherFeignClient", url = "\${biodiesel-second-washer.url}")
interface SecondWasherClient {

    @PostMapping("/v1/supply", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postSupply(@RequestBody supplyRequest: SupplyRequest): SupplyResponse
}