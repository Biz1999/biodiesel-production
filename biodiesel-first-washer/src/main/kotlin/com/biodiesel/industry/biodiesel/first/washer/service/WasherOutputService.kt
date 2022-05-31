package com.biodiesel.industry.biodiesel.first.washer.service

import com.biodiesel.industry.biodiesel.first.washer.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.first.washer.integration.feign.SecondWasherService
import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class WasherOutputService(
    private val databaseRepository: DatabaseRepository,
    private val secondWasherService: SecondWasherService,
    @Value("\${output.amount}")
    private val outputAmount: Double
) {
    private val logger = LoggerFactory.getLogger(WasherOutputService::class.java)

    @Scheduled(fixedDelayString = ("\${output.time}"), initialDelay = 2000)
    fun execute() = try {
        logger.info("Starting process to leak washed biodiesel...")

        val washer = databaseRepository.getWasher()

        if (washer.amount <= 0)
            throw IllegalArgumentException("Insufficient amount in first washer")

        when (washer.amount < outputAmount) {
            true -> {
                logger.info("Leaking ${washer.amount} L...")
                secondWasherService.performSupply(washer.amount)
                databaseRepository.updateWasher(washer, -washer.amount, 0.0)
                    .also {
                        logger.info("Finished process to leak washed biodiesel = $it")
                    }
            }
            false ->{
                logger.info("Leaking $outputAmount L...")
                secondWasherService.performSupply(outputAmount)
                databaseRepository.updateWasher(washer, -outputAmount, 0.0)
                    .also {
                        logger.info("Finished process to leak washed biodiesel = $it")
                    }
            }
        }
    } catch (ex: FeignException) {
        logger.error("Cannot supply second Washer. ${ex.message}")
    }
}