package com.biodiesel.industry.biodiesel.etoh.tank.controller

import com.biodiesel.industry.biodiesel.etoh.tank.controller.response.TankOutputResponse
import com.biodiesel.industry.biodiesel.etoh.tank.controller.response.TankSupplyResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class EtohTankController {
    @PostMapping("/supply")
    @ResponseStatus(HttpStatus.CREATED)
    fun postSupply(): TankSupplyResponse{


    }


    @PostMapping("/output")
    @ResponseStatus(HttpStatus.OK)
    fun postOutput(): TankOutputResponse{}


}