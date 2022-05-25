package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.converter.toDomain
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.converter.toEntityOutput
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.converter.toEntitySupply
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val naohTankRepository: PostgresRepository
){

    private val logger = LoggerFactory.getLogger(DatabaseRepository::class.java)

    fun getNaohTank(): NaohTank {
        logger.info("Starting process to retrieve tank information...")

        return naohTankRepository.getById(0).toDomain()
            .also {
                logger.info("Finished process to retrieve tank information. Tank=$it")
            }
    }

    fun updateTankAmountBySupply(amount: Double, naohTank: NaohTank): NaohTank {
        logger.info("Starting process to update tank amount with $amount L...")

        val naohTankEntity = naohTank.toEntitySupply(amount)

        naohTankRepository.save(naohTankEntity)

        return naohTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with $amount L.")
            }
    }

    fun updateTankAmountByOutput(amount: Double, naohTank: NaohTank): NaohTank {
        logger.info("Starting process to update tank amount with ${-amount} L...")

        val naohTankEntity = naohTank.toEntityOutput(-amount)

        naohTankRepository.save(naohTankEntity)

        return naohTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with ${-amount} L.")
            }
    }
}