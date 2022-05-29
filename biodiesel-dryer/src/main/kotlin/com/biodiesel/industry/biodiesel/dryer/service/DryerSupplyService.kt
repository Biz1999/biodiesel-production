package com.biodiesel.industry.biodiesel.dryer.service

import com.biodiesel.industry.biodiesel.dryer.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.dryer.model.Dryer
import com.biodiesel.industry.biodiesel.dryer.model.request.DryerSupplyRequest
import com.biodiesel.industry.biodiesel.dryer.service.converter.toDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DryerSupplyService(
    private val databaseRepository: DatabaseRepository
) {
    private val logger = LoggerFactory.getLogger(DryerSupplyService::class.java)

    fun execute(dryerSupplyRequest: DryerSupplyRequest): Dryer {
        logger.info("Starting to supply dryer with ${dryerSupplyRequest.amount}L...")

        val dryer = databaseRepository.getDryer()

        return databaseRepository.updateDryerAmountSupply(dryerSupplyRequest.toDomain(dryer))
            .also {
                logger.info("Finished process to supply dryer. [Dryer=$it]")
            }
    }
}