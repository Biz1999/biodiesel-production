package com.biodiesel.industry.biodiesel.oil.tank.application.service.service

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.kafka.publisher.ReactorPublisher
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank
import com.biodiesel.industry.biodiesel.oil.tank.application.service.TankOutputUseCase
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TankOutputService(
    private val oilTankRepository: DatabaseRepository,
    private val reactorPublisher: ReactorPublisher,
    @Value("\${oil-tank.output}")
    private val oilTankOutput: Double
) : TankOutputUseCase {

    private val logger = LoggerFactory.getLogger(TankOutputService::class.java)

    override fun execute(): OilTank {
        val oilTank = oilTankRepository.getOilTank()

        logger.info("Starting process to update tank information with ${-oilTankOutput} L")

        reactorPublisher.send(oilTank.toString())

        return oilTankRepository.updateTankAmountByOutput(oilTankOutput, oilTank)
            .also {
                logger.info("Finished process to update tank information. Tank=$it")
            }
    }
}