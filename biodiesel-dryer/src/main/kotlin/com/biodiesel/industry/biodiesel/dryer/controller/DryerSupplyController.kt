package com.biodiesel.industry.biodiesel.dryer.controller

import com.biodiesel.industry.biodiesel.dryer.controller.converter.toResponse
import com.biodiesel.industry.biodiesel.dryer.model.request.DryerSupplyRequest
import com.biodiesel.industry.biodiesel.dryer.model.response.DryerSupplyResponse
import com.biodiesel.industry.biodiesel.dryer.service.DryerSupplyService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class DryerSupplyController(
    private val dryerSupplyService: DryerSupplyService
) {
    private val logger = LoggerFactory.getLogger(DryerSupplyController::class.java)


    @PostMapping("/supply")
    @ResponseStatus(HttpStatus.CREATED)
    fun performDryerSupply(@RequestBody dryerSupplyRequest: DryerSupplyRequest): DryerSupplyResponse {
        logger.info("Starting process to perform dryer supply. [DryerSupplyRequest=$dryerSupplyRequest]")

        return dryerSupplyService.execute(dryerSupplyRequest).toResponse()
            .also {
                logger.info("Finished process to perform dryer supply. [DryerSupplyResponse=$it]")
            }
    }
}