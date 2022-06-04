package com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.api

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response.NaohOutputTankResponse
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response.NaohSupplyTankResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@RequestMapping("/v1")
interface NaohTankApi {

    @PostMapping("/supply")
    fun supplyNaohTank(): NaohSupplyTankResponse

    @PostMapping("/output")
    fun outputNaohTank(): NaohOutputTankResponse?
}