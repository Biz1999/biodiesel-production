package com.biodiesel.industry.biodiesel.decanter.integration.feign

import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterOutputRequest
import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterOutputResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("WasherThirdFeignClient", url = "\${biodiesel-washerThird.url}")
interface WasherThirdClient {

    @PostMapping("/v1/supply", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun performSupplyThirdWasher(@RequestBody decanterRequest: DecanterOutputRequest): DecanterOutputResponse


}