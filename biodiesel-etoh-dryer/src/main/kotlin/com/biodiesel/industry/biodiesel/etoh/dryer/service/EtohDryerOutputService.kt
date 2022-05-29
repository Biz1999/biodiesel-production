package com.biodiesel.industry.biodiesel.etoh.dryer.service

import com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.etoh.dryer.integration.kafka.publisher.DryerOutputPublisher
import com.biodiesel.industry.biodiesel.etoh.dryer.service.converter.objectToJson
import com.biodiesel.industry.biodiesel.etoh.dryer.service.converter.toRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class EtohDryerOutputService(
    private val databaseRepository: DatabaseRepository,
    private val dryerOutputPublisher: DryerOutputPublisher,
    @Value("\${output.amount}")
    private val dryerOutputAmount: Double,
    @Value("\${output.lost}")
    private val lostPercentage: Double
) {
    private val logger = LoggerFactory.getLogger(EtohDryerSupplyService::class.java)

    @Scheduled(fixedRateString = "\${output.time}")
    fun execute() {
        logger.info("Starting process to perform the dried etoh output ...")

        val etohDryer =  databaseRepository.getEtohDryer()

        if (etohDryer.amount < dryerOutputAmount){
            logger.info("Dryer can not leak insufficient EtOH")
            return
        }

        databaseRepository.updateEtohDryerAmountOutput(etohDryer)
            .also {
                logger.info("Finished process to update dryer info. [EtohDryer=$it]")
            }
        dryerOutputPublisher.publishMessage(toRequest(dryerOutputAmount, lostPercentage).objectToJson())
            .also {
                logger.info("Finished process to send message with $lostPercentage of loss.")
            }

    }
}