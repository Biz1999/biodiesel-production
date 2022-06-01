package com.biodiesel.industry.biodiesel.decanter.integration.database

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DatabaseRepository(
    private val DecanterRepository: PostgresRepository
){

    private val logger = LoggerFactory.getLogger(DatabaseRepository::class.java)

    fun getEtohTank(): DecanterTank {
        logger.info("Starting process to retrieve tank information...")

        return DecanterRepository.getById(0).toDomain()
            .also {
                logger.info("Finished process to retrieve tank information. Tank=$it")
            }
    }

    fun updateTankAmountBySupply(amount: Double, etohTank: DecanterTank): DecanterTank {
        logger.info("Starting process to update tank amount with $amount L...")

        val etohTankEntity = etohTank.toEntitySupply(amount)

        DecanterRepository.save(etohTankEntity)

        return etohTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with $amount L.")
            }
    }

    fun updateTankAmountByOutput(amount: Double, oilTank: DecanterTank): DecanterTank {
        logger.info("Starting process to update tank amount with ${-amount} L...")

        val oilTankEntity = oilTank.toEntityOutput(-amount)

        DecanterRepository.save(oilTankEntity)

        return oilTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with ${-amount} L.")
            }
    }
}