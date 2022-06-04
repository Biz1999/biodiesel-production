package com.biodiesel.industry.biodiesel.etoh.tank.integration.feign


import com.biodiesel.industry.biodiesel.etoh.tank.models.EtohResponse
import com.biodiesel.industry.biodiesel.etoh.tank.models.EtohSupply
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("reactorFeignClient", url = "\${biodiesel-reactor.url}")
interface ReactorClient {

    @PostMapping("/v1/supply/etoh", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createReactorSupply(@RequestBody reactorSupplyRequest: EtohSupply): EtohResponse
}