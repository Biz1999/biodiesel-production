package com.biodiesel.industry.biodiesel.etoh.tank.service

import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.converter.toRequest
import com.biodiesel.industry.biodiesel.etoh.tank.integration.feign.ReactorClient
import com.biodiesel.industry.biodiesel.etoh.tank.models.EtohTank
import feign.FeignException

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class TankOutputService(
    @Value("\${etoh-tank.output}")
    private val outputAmount: Double,

    private val etohTankRepository: DatabaseRepository,
    private val reactorClient: ReactorClient

) {
    private val logger = LoggerFactory.getLogger(TankOutputService::class.java)

    @Scheduled(fixedDelayString = ("\${output.time}"), initialDelay = 2000)
    fun outputEtohTank(): EtohTank? = try {

        val tankSupply = etohTankRepository.getEtohTank()

        if (tankSupply.amount <= outputAmount)
            throw IllegalArgumentException("Insufficient amount in EtOH tank = ${tankSupply.amount}L")


        val etohTankSupply = reactorClient.createReactorSupply(tankSupply.toRequest(outputAmount))

        etohTankRepository.updateTankAmountBySupply(-(outputAmount - etohTankSupply.returnedAmount), tankSupply)
            .also {
                logger.info("Finished process to update tank information. Tank EtOH=$it")
            }

        logger.info("Output of %.2f L EtOH".format(outputAmount - etohTankSupply.returnedAmount))
        tankSupply
    } catch (ex: FeignException) {
        logger.error("Reactor unaivable ${ex.message}")
        null
    }

}