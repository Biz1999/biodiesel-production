package com.biodiesel.industry.biodiesel.oil.tank.application.service

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.ReactorService
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank
import com.biodiesel.industry.biodiesel.oil.tank.application.port.input.TankOutputUseCase
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TankOutputService(
    private val oilTankRepository: DatabaseRepository,
    private val reactorService: ReactorService,
    @Value("\${oil-tank.output}")
    private val oilTankOutput: Double
) : TankOutputUseCase {

    private val logger = LoggerFactory.getLogger(TankOutputService::class.java)

    override fun execute(): OilTank {
        val oilTank = oilTankRepository.getOilTank()

        if (oilTank.amount <= oilTankOutput)
            throw IllegalArgumentException("Insufficient amount in oil tank")

        logger.info("Starting process to supply reactor information with ${-oilTankOutput} L")

        reactorService.performReactorSupply(oilTank)

        return oilTankRepository.updateTankAmountByOutput(oilTankOutput, oilTank)
            .also {
                logger.info("Finished process to supply reactor information. Tank=$it")
            }
    }
}