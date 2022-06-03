package com.biodiesel.industry.biodiesel.decanter.integration.database

import com.biodiesel.industry.biodiesel.decanter.integration.database.converter.toDomain
import com.biodiesel.industry.biodiesel.decanter.integration.database.converter.toEntityOutput
import com.biodiesel.industry.biodiesel.decanter.integration.database.converter.toEntitySupply
import com.biodiesel.industry.biodiesel.decanter.integration.database.postgres.PostgresRepository
import com.biodiesel.industry.biodiesel.decanter.models.DecanterTank
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DatabaseRepository(
    private val DecanterRepository: PostgresRepository
){

    private val logger = LoggerFactory.getLogger(DatabaseRepository::class.java)

    fun getDecanterEntity(): DecanterTank {
        logger.info("Starting process to retrieve Decanter information...")

        return DecanterRepository.getById(0).toDomain()
            .also {
                logger.info("Finished process to retrieve Decanter information. Decanter=$it")
            }
    }

    fun updateDecanterAmountBySupply(amount: Double, decanterTank: DecanterTank, capacity: Double): DecanterTank {
        logger.info("Starting process to update tank amount with $amount L...")

        val decanterTankEntity = decanterTank.toEntitySupply(amount, capacity)

        DecanterRepository.save(decanterTankEntity)

        return decanterTankEntity.toDomain()
            .also {
                logger.info("Finished process to update decanter amount with $amount L.")
            }
    }


    fun updateDecanterAmountByOutput(amount: Double, decanterTank: DecanterTank, capacity: Double): DecanterTank {
        logger.info("Starting process to update tank amount with $amount L...")

        val decanterTankEntity = decanterTank.toEntityOutput(amount, capacity)

        DecanterRepository.save(decanterTankEntity)

        return decanterTankEntity.toDomain()
            .also {
                logger.info("Finished process to update decanter amount with $amount L.")
            }
    }

}