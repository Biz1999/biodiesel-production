package com.biodiesel.industry.biodiesel.etoh.tank.service

import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.etoh.tank.models.EtohTank
import com.biodiesel.industry.biodiesel.etoh.tank.models.TankSupplyResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class TankSupplyService(
    @Value("\${etoh-tank.input}")
    private val supplyAmount: Double,

    private val etohTankRepository: DatabaseRepository,
) {

    private val logger = LoggerFactory.getLogger(TankSupplyService::class.java)

    @Scheduled(fixedDelayString = ("\${supply.time}"), initialDelay = 2000)
    fun supplyEtohTank(): EtohTank {

        logger.info("Starting process to supply the EtOH tank with $supplyAmount L")

        val tankSupply = etohTankRepository.getEtohTank()

        return etohTankRepository.updateTankAmountBySupply(supplyAmount, tankSupply)
            .also {
                logger.info("Finished process to update tank information. Tank=$it")
            }

    }

}