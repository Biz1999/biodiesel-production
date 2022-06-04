package com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.api

import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response.TankOutputResponse
import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response.TankSupplyResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus


@RequestMapping("/v1")
interface OilTankApi {

    @PostMapping("/supply")
    @ResponseStatus(HttpStatus.CREATED)
    fun postSupply(): TankSupplyResponse

    @PostMapping("/output")
    @ResponseStatus(HttpStatus.OK)
    fun postOutput(): TankOutputResponse
}