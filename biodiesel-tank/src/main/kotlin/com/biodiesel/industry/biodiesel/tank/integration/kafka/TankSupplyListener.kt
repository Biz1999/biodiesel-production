package com.biodiesel.industry.biodiesel.tank.integration.kafka

import com.biodiesel.industry.biodiesel.tank.integration.kafka.converter.jsonToObject
import com.biodiesel.industry.biodiesel.tank.service.SupplyBiodieselTankService
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class TankSupplyListener(
    private val supplyBiodieselTankService: SupplyBiodieselTankService
) {
    private val logger = LoggerFactory.getLogger(TankSupplyListener::class.java)

    @KafkaListener(id = "receiveBiodiesel", topics = ["\${topic.name.biodiesel.listener}"])
    fun listenBiodieselSupply(message: String){
        logger.info("Starting process to perform biodiesel supply...")

        val biodieselSupply = message.jsonToObject()

        supplyBiodieselTankService.execute(biodieselSupply)
            .also {
                logger.info("Finished process to perform biodiesel supply. [BiodieselTank=$it]")
            }
    }
}