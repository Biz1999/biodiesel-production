package com.biodiesel.industry.biodiesel.third.washer.integration.feign.client

import com.biodiesel.industry.biodiesel.third.washer.model.request.SupplyRequest
import com.biodiesel.industry.biodiesel.third.washer.model.response.SupplyResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("secondWasherFeignClient", url = "\${biodiesel-dryer.url}")
interface DryerClient {

    @PostMapping("/v1/supply", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun postSupply(@RequestBody supplyRequest: SupplyRequest): SupplyResponse
}