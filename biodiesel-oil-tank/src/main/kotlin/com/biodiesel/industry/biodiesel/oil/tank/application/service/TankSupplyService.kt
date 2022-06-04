package com.biodiesel.industry.biodiesel.oil.tank.application.service

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank
import com.biodiesel.industry.biodiesel.oil.tank.application.port.input.TankSupplyUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TankSupplyService(
    private val oilTankRepository: DatabaseRepository
): TankSupplyUseCase {

    private val logger = LoggerFactory.getLogger(TankSupplyService::class.java)

    override fun execute(amount: Double): OilTank {
        val tankSupply = oilTankRepository.getOilTank()

        logger.info("Starting process to update tank information with $amount L")

        return oilTankRepository.updateTankAmountBySupply(amount, tankSupply)
            .also {
                logger.info("Finished process to update tank information. Tank=$it")
            }

    }
}