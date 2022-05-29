package com.biodiesel.industry.biodiesel.glycerin.tank.service

import com.biodiesel.industry.biodiesel.glycerin.tank.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.glycerin.tank.model.GlycerinTank
import com.biodiesel.industry.biodiesel.glycerin.tank.model.request.GlycerinSupply
import com.biodiesel.industry.biodiesel.glycerin.tank.service.converter.toDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SupplyGlycerinTankService(
    private val databaseRepository: DatabaseRepository
) {
    private val logger = LoggerFactory.getLogger(SupplyGlycerinTankService::class.java)

    fun execute(glycerinSupply: GlycerinSupply): GlycerinTank {
        logger.info("Starting process to update glycerin tank with [GlycerinSupply=$glycerinSupply]")

        val glycerinTank = databaseRepository.getBiodieselTank()

        return databaseRepository.updateBiodieselTank(glycerinSupply.toDomain(glycerinTank))
            .also {
                logger.info("Finished process to update glycerin tank. [GlycerinTank=$it]")
            }
    }
}