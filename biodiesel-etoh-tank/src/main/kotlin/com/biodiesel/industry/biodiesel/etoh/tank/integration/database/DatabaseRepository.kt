package com.biodiesel.industry.biodiesel.etoh.tank.integration.database

import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.converter.toDomain
import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.converter.toEntityOutput
import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.converter.toEntitySupply
import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.postgres.PostgresRepository
import com.biodiesel.industry.biodiesel.etoh.tank.models.EtohTank
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DatabaseRepository(
    private val etohTankRepository: PostgresRepository
){

    private val logger = LoggerFactory.getLogger(DatabaseRepository::class.java)

    fun getEtohTank(): EtohTank {
        logger.info("Starting process to retrieve tank information...")

        return etohTankRepository.getById(0).toDomain()
            .also {
                logger.info("Finished process to retrieve tank information. Tank=$it")
            }
    }

    fun updateTankAmountBySupply(amount: Double, etohTank: EtohTank): EtohTank {
        logger.info("Starting process to update tank amount with $amount L...")

        val etohTankEntity = etohTank.toEntitySupply(amount)

        etohTankRepository.save(etohTankEntity)

        return etohTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with $amount L.")
            }
    }

    fun updateTankAmountByOutput(amount: Double, oilTank: EtohTank): EtohTank {
        logger.info("Starting process to update tank amount with ${-amount} L...")

        val oilTankEntity = oilTank.toEntityOutput(-amount)

        etohTankRepository.save(oilTankEntity)

        return oilTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with ${-amount} L.")
            }
    }
}