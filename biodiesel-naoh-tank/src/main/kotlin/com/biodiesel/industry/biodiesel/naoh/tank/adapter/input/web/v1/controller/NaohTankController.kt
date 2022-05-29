package com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.api.NaohTankApi
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.converter.toTankOutputResponse
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.converter.toTankSupplyResponse
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response.NaohOutputTankResponse
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.input.web.v1.response.NaohSupplyTankResponse
import com.biodiesel.industry.biodiesel.naoh.tank.application.port.input.TankOutputUseCase
import com.biodiesel.industry.biodiesel.naoh.tank.application.port.input.TankSupplyUseCase
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class NaohTankController(
    private val tankOutputUseCase: TankOutputUseCase,
    private val tankSupplyUseCase: TankSupplyUseCase,
    @Value("\${naoh-tank.input}")
    private val supplyAmount: Double
): NaohTankApi {
    private val logger = LoggerFactory.getLogger(NaohTankController::class.java)

    @Scheduled(fixedDelayString = ("\${supply.time}"), initialDelay = 2000)
    override fun supplyNaohTank(): NaohSupplyTankResponse {

        logger.info("Starting process to supply the NaOH tank with $supplyAmount L")

        return tankSupplyUseCase.execute(supplyAmount).toTankSupplyResponse()
            .also {
                logger.info("Finished process to supply the NaOH tank with TankSupplyResponse=$it")
            }
    }

    //@Scheduled(fixedDelayString = ("\${output.time}"), initialDelay = 2000)
    override fun outputNaohTank(): NaohOutputTankResponse {
        logger.info("Starting process to empty the NaOH tank...")

        return tankOutputUseCase.execute().toTankOutputResponse()
            .also {
                logger.info("Finished process to empty the NaOH tank with TankOutputResponse=$it")
            }
    }
}