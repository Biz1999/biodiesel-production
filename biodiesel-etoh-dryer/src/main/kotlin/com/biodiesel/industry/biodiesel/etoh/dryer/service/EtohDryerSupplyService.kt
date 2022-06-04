package com.biodiesel.industry.biodiesel.etoh.dryer.service

import com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.etoh.dryer.model.EtohDryer
import com.biodiesel.industry.biodiesel.etoh.dryer.model.request.EtohSupply
import com.biodiesel.industry.biodiesel.etoh.dryer.service.converter.toDomain
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EtohDryerSupplyService(
    private val databaseRepository: DatabaseRepository
) {
    private val logger = LoggerFactory.getLogger(EtohDryerSupplyService::class.java)

    fun execute(etohSupply: EtohSupply): EtohDryer{
        logger.info("Starting to supply etoh dryer with ${etohSupply.amount}L...")

        val etohDryer = databaseRepository.getEtohDryer()

        return databaseRepository.updateEtohDryerAmountSupply(etohSupply.toDomain(etohDryer))
            .also {
                logger.info("Finished process to supply EtOH dryer. [EtohDryer=$it]")
            }
    }
}