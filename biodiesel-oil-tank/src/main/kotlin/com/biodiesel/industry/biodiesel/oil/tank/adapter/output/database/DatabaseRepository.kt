package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.helper.toEntityOutput
import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.helper.toEntitySupply
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank
import com.biodiesel.industry.biodiesel.oil.tank.application.service.helper.toDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val oilTankRepository: PostgresRepository
){

    private val logger = LoggerFactory.getLogger(DatabaseRepository::class.java)

    fun getOilTank(): OilTank {
        logger.info("Starting process to retrieve tank information...")

        return oilTankRepository.getById(0).toDomain()
            .also {
                logger.info("Finished process to retrieve tank information. Tank=$it")
            }
    }

    fun updateTankAmountBySupply(amount: Double, oilTank: OilTank): OilTank {
        logger.info("Starting process to update tank amount with $amount L...")

        val oilTankEntity = oilTank.toEntitySupply(amount)

        oilTankRepository.save(oilTankEntity)

        return oilTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with $amount L.")
            }
    }

    fun updateTankAmountByOutput(amount: Double, oilTank: OilTank): OilTank {
        logger.info("Starting process to update tank amount with ${-amount} L...")

        val oilTankEntity = oilTank.toEntityOutput(-amount)

        oilTankRepository.save(oilTankEntity)

        return oilTankEntity.toDomain()
            .also {
                logger.info("Finished process to update tank amount with ${-amount} L.")
            }
    }
}