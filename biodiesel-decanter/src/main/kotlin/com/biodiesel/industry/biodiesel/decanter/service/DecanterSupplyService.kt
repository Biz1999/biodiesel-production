package com.biodiesel.industry.biodiesel.decanter.service

import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterRequest
import com.biodiesel.industry.biodiesel.decanter.controller.response.DecanterResponse
import com.biodiesel.industry.biodiesel.decanter.integration.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.decanter.integration.database.converter.toResponse
import com.biodiesel.industry.biodiesel.decanter.integration.database.postgres.PostgresRepository
import com.biodiesel.industry.biodiesel.decanter.models.DecanterTank
import org.apache.tomcat.jni.Local
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class DecanterSupplyService(
    @Value("\${capacityDecanter}")
    private val capacity: Double,

    val decanterRepository: DatabaseRepository
) {

    private val logger = LoggerFactory.getLogger(DecanterSupplyService::class.java)

    fun supplyDecanter(ReactorRequest: DecanterRequest): ResponseEntity<*> {
        logger.info("Starting request to perform Reactor supply with [RecanterRequest=$ReactorRequest]")

        val decanter = decanterRepository.getDecanterEntity()



        if(decanter.status == DecanterTank.Status.UNAVAILABLE)
            throw IllegalArgumentException("Decanter can not receive Reactor now, UNAVAILABLE")

        if((decanter.amount+ReactorRequest.amount)>capacity)
            throw IllegalArgumentException("Decanter limits can't be exceed")

        if(LocalDateTime.now().isBefore(decanter.supplyTime.plusSeconds(5)))
            throw IllegalArgumentException("Decanter in rest")


        val actualizeDecanter = decanterRepository.updateDecanterAmountBySupply(ReactorRequest.amount, decanter, capacity)

        return ResponseEntity.ok(actualizeDecanter.toResponse())
            .also {
                logger.info("Finished process to perform Reactor supply with response [ReactorRequest=$it]")
            }

    }
}