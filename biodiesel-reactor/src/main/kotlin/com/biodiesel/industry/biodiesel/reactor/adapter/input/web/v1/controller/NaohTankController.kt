package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api.NaohTankApi
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter.toDomain
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.converter.toNaohResponse
import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.request.NaohRequest
import com.biodiesel.industry.biodiesel.reactor.application.port.input.NaohSupplyReactorUseCase
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class NaohTankController(
    private val naohSupplyReactorUseCase: NaohSupplyReactorUseCase
): NaohTankApi {
    private val logger = LoggerFactory.getLogger(NaohTankController::class.java)

    override fun performNaohSupply(naohRequest: NaohRequest): ResponseEntity<*> {
        logger.info("Starting request to perform NaOH supply with [NaohRequest=$naohRequest]")

        val etohResponse = naohSupplyReactorUseCase.execute(naohRequest.toDomain()).toNaohResponse()

        return ResponseEntity.ok(etohResponse)
            .also {
                logger.info("Finished process to perform NaOH supply with response [NaohResponse=$it]")
            }
    }
}