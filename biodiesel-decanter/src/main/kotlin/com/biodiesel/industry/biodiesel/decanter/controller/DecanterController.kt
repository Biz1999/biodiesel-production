package com.biodiesel.industry.biodiesel.decanter.controller

import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterRequest
import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterResponse
import com.biodiesel.industry.biodiesel.decanter.service.DecanterSupplyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class DecanterController(
    private val DecanterSupplyService: DecanterSupplyService
) {

    @PostMapping("/supply")
    @ResponseStatus(HttpStatus.CREATED)
    fun postSupply(@RequestBody ReactorRequest: DecanterRequest): ResponseEntity<*> {
        return DecanterSupplyService.supplyDecanter(ReactorRequest)
    }

}