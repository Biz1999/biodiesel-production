package com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.reactor.adapter.input.web.v1.api.ReactorApi
import com.biodiesel.industry.biodiesel.reactor.application.port.input.ReactorOutputUseCase
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.RestController

@RestController
class ReactorController(
    private val reactorOutputUseCase: ReactorOutputUseCase
): ReactorApi {
    private val logger = LoggerFactory.getLogger(ReactorController::class.java)

    @Scheduled(fixedDelayString = ("\${output.time}"), initialDelay = 2000)
    override fun performProcessing(): ResponseEntity<*> {
        logger.info("Starting process to perform reactor output to decanter...")

        val reactorOutput = reactorOutputUseCase.execute()

        return ResponseEntity.ok(reactorOutput)
            .also {
                logger.info("Finished process to perform reactor output with response [Reactor=$it]")
            }
    }
}