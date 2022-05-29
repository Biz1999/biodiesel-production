package com.biodiesel.industry.biodiesel.glycerin.tank.integration.kafka

import com.biodiesel.industry.biodiesel.glycerin.tank.integration.kafka.converter.jsonToObject
import com.biodiesel.industry.biodiesel.glycerin.tank.service.SupplyGlycerinTankService
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class TankSupplyListener(
    private val supplyGlycerinTankService: SupplyGlycerinTankService
) {
    private val logger = LoggerFactory.getLogger(TankSupplyListener::class.java)

    @KafkaListener(id = "receiveGlycerin", topics = ["\${topic.name.glycerin.listener}"])
    fun listenGlycerinSupply(message: String){
        logger.info("Starting process to perform glycerin supply...")

        val glycerinSupply = message.jsonToObject()

        supplyGlycerinTankService.execute(glycerinSupply)
            .also {
                logger.info("Finished process to perform glycerin supply. [GlycerinTank=$it]")
            }
    }
}