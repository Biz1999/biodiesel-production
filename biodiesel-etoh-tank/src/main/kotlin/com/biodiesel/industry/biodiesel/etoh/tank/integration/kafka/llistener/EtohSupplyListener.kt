package com.biodiesel.industry.biodiesel.etoh.tank.integration.kafka.llistener

import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.converter.jsonToObject
import com.biodiesel.industry.biodiesel.etoh.tank.models.EtohTank
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class EtohSupplyListener(
    private val etohTankRepository: DatabaseRepository
) {

    private val logger = LoggerFactory.getLogger(EtohSupplyListener::class.java)

    @KafkaListener(id = "receiveDryer", topics = ["\${topic.name.etoh.listener}"])
    fun listenDryerSupply(message: String): EtohTank {

        logger.info("Starting the process to fill the EtOH tank through the dryer")

        val supplyAmount = message.jsonToObject()
        val tankSupply = etohTankRepository.getEtohTank()

        return etohTankRepository.updateTankAmountBySupply(supplyAmount.amount, tankSupply)
            .also {
                logger.info("Finished process to update tank information. Tank=$it")
            }


    }



}