package com.biodiesel.industry.biodiesel.third.washer.service

import com.biodiesel.industry.biodiesel.third.washer.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.third.washer.model.Washer
import com.biodiesel.industry.biodiesel.third.washer.model.request.SupplyRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class WasherSupplyService(
    private val databaseRepository: DatabaseRepository,
    @Value("\${emulsion.percentage}")
    private val emulsionPercentage: Double
) {
    private val logger = LoggerFactory.getLogger(WasherSupplyService::class.java)

    fun execute(supplyRequest: SupplyRequest): Washer {
        logger.info("Starting process to execute third washer supply [$supplyRequest]...")

        val washer = databaseRepository.getWasher()

        return databaseRepository.updateWasher(
            washer,
            supplyRequest.amount  - (supplyRequest.amount * emulsionPercentage),
            (supplyRequest.amount * emulsionPercentage)
        )
            .also {
                logger.info("Finished process to execute third washer supply. [$it]")
            }
    }
}