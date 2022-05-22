package com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.controller

import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.api.OilTankApi
import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.helper.toTankOutputResponse
import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.helper.toTankSupplyResponse
import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response.TankOutputResponse
import com.biodiesel.industry.biodiesel.oil.tank.adapter.input.web.v1.response.TankSupplyResponse
import com.biodiesel.industry.biodiesel.oil.tank.application.service.TankOutputUseCase
import com.biodiesel.industry.biodiesel.oil.tank.application.service.TankSupplyUseCase
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random


private const val INTERVAL: Long = 1000

@RestController
class OilTankController(
    private val tankSupplyUseCase: TankSupplyUseCase,
    private val tankOutputUseCase: TankOutputUseCase
    ): OilTankApi {

    private val logger = LoggerFactory.getLogger(OilTankController::class.java)

    @Scheduled(fixedDelayString = ("\${supply.time}"), initialDelay = 2000)
    override fun postSupply(): TankSupplyResponse {
        val supplyAmount = Random.nextDouble(1.0, 2.0)

        logger.info("Starting process to supply the oil tank with $supplyAmount L")

        return tankSupplyUseCase.execute(supplyAmount).toTankSupplyResponse()
            .also {
                logger.info("Finished process to supply the oil tank with TankSupplyResponse=$it")
            }
    }

    @Scheduled(fixedDelayString = ("\${output.time}"), initialDelay = 2000)
    override fun postOutput(): TankOutputResponse {
        logger.info("Starting process to empty the oil tank...")

        return tankOutputUseCase.execute().toTankOutputResponse()
            .also {
                logger.info("Finished process to empty the oil tank with TankSupplyResponse=$it")
            }
    }
}