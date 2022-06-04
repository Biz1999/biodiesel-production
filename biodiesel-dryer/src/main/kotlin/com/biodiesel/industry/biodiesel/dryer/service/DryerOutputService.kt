package com.biodiesel.industry.biodiesel.dryer.service

import com.biodiesel.industry.biodiesel.dryer.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.dryer.integration.kafka.DryerOutputPublisher
import com.biodiesel.industry.biodiesel.dryer.service.converter.objectToJson
import com.biodiesel.industry.biodiesel.dryer.service.converter.toRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class DryerOutputService(
    private val databaseRepository: DatabaseRepository,
    private val dryerOutputPublisher: DryerOutputPublisher,
    @Value("\${output.amount}")
    private val dryerOutputAmount: Double,
    @Value("\${output.lost}")
    private val lostPercentage: Double
) {
    private val logger = LoggerFactory.getLogger(DryerOutputService::class.java)

    @Scheduled(fixedRateString = "\${output.time}", initialDelay = 5000)
    fun execute() {
        logger.info("Starting process to perform the dried Biodiesel output ...")

        val dryer =  databaseRepository.getDryer()

        if (dryer.amount < dryerOutputAmount){
            logger.info("Dryer can not leak insufficient Biodiesel")
            return
        }

        databaseRepository.updateDryerAmountOutput(dryer)
            .also {
                logger.info("Finished process to update dryer info. [Dryer=$it]")
            }
        dryerOutputPublisher.publishMessage(toRequest(dryerOutputAmount, lostPercentage).objectToJson())
            .also {
                logger.info("Finished process to send message with $lostPercentage of loss.")
            }
    }
}