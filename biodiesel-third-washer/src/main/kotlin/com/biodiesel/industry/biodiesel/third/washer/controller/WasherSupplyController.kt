package com.biodiesel.industry.biodiesel.third.washer.controller

import com.biodiesel.industry.biodiesel.third.washer.controller.converter.toResponse
import com.biodiesel.industry.biodiesel.third.washer.model.request.SupplyRequest
import com.biodiesel.industry.biodiesel.third.washer.model.response.SupplyResponse
import com.biodiesel.industry.biodiesel.third.washer.service.WasherSupplyService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class WasherSupplyController(
    private val washerSupplyService: WasherSupplyService
) {
    private val logger = LoggerFactory.getLogger(WasherSupplyController::class.java)


    @PostMapping("/supply")
    fun performSupply(@RequestBody supplyRequest: SupplyRequest): SupplyResponse {
        logger.info("Starting process to perform third washer supply [$supplyRequest]...")

        return washerSupplyService.execute(supplyRequest).toResponse()
            .also {
                logger.info("Finished process to perform third washer supply. [$it]")
            }
    }
}