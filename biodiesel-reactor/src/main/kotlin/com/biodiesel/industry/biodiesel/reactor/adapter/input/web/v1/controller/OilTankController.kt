package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api.OilTankApi
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter.toDomain
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter.toOilResponse
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.OilRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.OilResponse
import com.biodiesel.industry.biodiesel.reactor.application.port.input.OilSupplyReactorUseCase
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class OilTankController(
    private val oilSupplyReactorUseCase: OilSupplyReactorUseCase
): OilTankApi {
    private val logger = LoggerFactory.getLogger(OilTankController::class.java)

    override fun performOilSupply(oilRequest: OilRequest): ResponseEntity<*> {


        logger.info("Starting request to perform oil supply with [OilRequest=${Gson().toJson(oilRequest)}]")

        val oilResponse = oilSupplyReactorUseCase.execute(oilRequest.toDomain()).toOilResponse()

        return ResponseEntity.ok(oilResponse)
            .also {
                logger.info("Finished process to perform oil supply with response [OilResponse=${Gson().toJson(it)}]")
            }
    }
}