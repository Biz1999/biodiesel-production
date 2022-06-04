package com.biodiesel.industry.biodiesel.tank.service

import com.biodiesel.industry.biodiesel.tank.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.tank.model.BiodieselTank
import com.biodiesel.industry.biodiesel.tank.model.request.BiodieselSupply
import com.biodiesel.industry.biodiesel.tank.service.converter.toDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SupplyBiodieselTankService(
    private val databaseRepository: DatabaseRepository
) {
    private val logger = LoggerFactory.getLogger(SupplyBiodieselTankService::class.java)

    fun execute(biodieselSupply: BiodieselSupply): BiodieselTank {
        logger.info("Starting process to update biodiesel tank with [BiodieselSupply=$biodieselSupply]")

        val biodieselTank = databaseRepository.getBiodieselTank()

        return databaseRepository.updateBiodieselTank(biodieselSupply.toDomain(biodieselTank))
            .also {
                logger.info("Finished process to update biodiesel tank. [BiodieselTank=$it]")
            }
    }
}