package com.biodiesel.industry.biodiesel.etoh.dryer.integration.kafka.listener

import com.biodiesel.industry.biodiesel.etoh.dryer.integration.kafka.converter.jsonToObject
import com.biodiesel.industry.biodiesel.etoh.dryer.service.EtohDryerSupplyService
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class DryerSupplyListener(
    private val etohDryerSupplyService: EtohDryerSupplyService
) {
    private val logger = LoggerFactory.getLogger(DryerSupplyListener::class.java)

    @KafkaListener(id = "receiveEtohDryer", topics = ["\${topic.name.etoh.listener}"])
    fun listenEtohDryerSupply(message: String) {
        logger.info("Starting process to perform biodiesel supply...")

        val biodieselSupply = message.jsonToObject()

        etohDryerSupplyService.execute(biodieselSupply)
            .also {
                logger.info("Finished process to perform biodiesel supply. [BiodieselTank=$it]")
            }
    }
}