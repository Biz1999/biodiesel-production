package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api.EtohTankApi
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter.toDomain
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter.toEtohResponse
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter.toOilResponse
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.EtohRequest
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.response.EtohResponse
import com.biodiesel.industry.biodiesel.reactor.application.port.input.EtohSupplyReactorUseCase
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EtohTankController(
    private val etohSupplyReactorUseCase: EtohSupplyReactorUseCase
): EtohTankApi {
    private val logger = LoggerFactory.getLogger(EtohTankController::class.java)

    override fun performEtohSupply(etohRequest: EtohRequest): ResponseEntity<*>  {
        logger.info("Starting request to perform oil supply with [OilRequest=${Gson().toJson(etohRequest)}]")

        val etohResponse = etohSupplyReactorUseCase.execute(etohRequest.toDomain()).toEtohResponse()

        return ResponseEntity.ok(etohResponse)
            .also {
                logger.info("Finished process to perform oil supply with response [OilResponse=${Gson().toJson(it)}]")
            }
    }
}