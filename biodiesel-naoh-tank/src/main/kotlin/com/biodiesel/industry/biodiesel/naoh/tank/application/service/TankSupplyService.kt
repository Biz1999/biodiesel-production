package com.biodiesel.industry.biodiesel.naoh.tank.application.service

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank
import com.biodiesel.industry.biodiesel.naoh.tank.application.port.input.TankSupplyUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TankSupplyService(
    private val naohTankRepository: DatabaseRepository
): TankSupplyUseCase {
    private val logger = LoggerFactory.getLogger(TankSupplyService::class.java)

    override fun execute(amount: Double): NaohTank {
        val tankSupply = naohTankRepository.getNaohTank()

        logger.info("Starting process to update tank information with $amount L")

        return naohTankRepository.updateTankAmountBySupply(amount, tankSupply)
            .also {
                logger.info("Finished process to update tank information. Tank=$it")
            }

    }
}