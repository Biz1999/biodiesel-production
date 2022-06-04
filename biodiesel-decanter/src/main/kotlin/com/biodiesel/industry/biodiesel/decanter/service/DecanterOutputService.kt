package com.biodiesel.industry.biodiesel.decanter.service

import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterOutputRequest
import com.biodiesel.industry.biodiesel.decanter.controller.response.objectToJson
import com.biodiesel.industry.biodiesel.decanter.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.decanter.integration.feign.WasherFirstClient
import com.biodiesel.industry.biodiesel.decanter.integration.feign.WasherSecondClient
import com.biodiesel.industry.biodiesel.decanter.integration.feign.WasherThirdClient
import com.biodiesel.industry.biodiesel.decanter.integration.kafka.publisher.DryerOutputPublisher
import com.biodiesel.industry.biodiesel.decanter.integration.kafka.publisher.GlycerinOutputPublisher
import com.biodiesel.industry.biodiesel.decanter.models.DecanterTank
import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class DecanterOutputService(

    @Value("\${capacityDecanter}")
    private val capacity: Double,

    val decanterRepository: DatabaseRepository,

    val firstWasherClient: WasherFirstClient,
    val secondWasherClient: WasherSecondClient,
    val thirdWasherClient: WasherThirdClient,
    val dryerOutputPublisher: DryerOutputPublisher,
    val glycerinOutputPublisher: GlycerinOutputPublisher
) {

    private val logger = LoggerFactory.getLogger(DecanterOutputService::class.java)

    @Scheduled(fixedDelayString = ("\${output.time}"), initialDelay = 2000)
    fun DecanterOutput(): DecanterTank = try {

        logger.info("Starting process to perform washer, glycerin and EtOH output to decanter...")

        val decanter = decanterRepository.getDecanterEntity()

        if (decanter.status == DecanterTank.Status.AVAILABLE)
            throw IllegalArgumentException("Decanter in supply")

        val washerFirst = decanter.amount * 0.96
        //val washerSecond = decanter.amount * 0.96 / 3
        //val washerThird = decanter.amount * 0.96 / 3
        val EtOHOutputDryer = decanter.amount * 0.03
        val glycerinOutput = decanter.amount * 0.01

        firstWasherClient.performSupplyFirstWasher(DecanterOutputRequest(washerFirst))
        //secondWasherClient.performSupplySecondWasher(DecanterOutputRequest(washerSecond))
        //thirdWasherClient.performSupplyThirdWasher(DecanterOutputRequest(washerThird))
        dryerOutputPublisher.publishMessage(DecanterOutputRequest(EtOHOutputDryer).objectToJson())
        glycerinOutputPublisher.publishMessage(DecanterOutputRequest(glycerinOutput).objectToJson())

        val updateOutputDecanter = decanterRepository.updateDecanterAmountByOutput(-decanter.amount, decanter, capacity)

        updateOutputDecanter
    } catch (ex: FeignException) {
        throw ex
    }
}

