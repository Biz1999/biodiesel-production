package com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter

import com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.client.DecanterClient
import com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.converter.toDomain
import com.biodiesel.industry.biodiesel.reactor.adapter.output.feign.decanter.converter.toRequest
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.DecanterReactor
import com.biodiesel.industry.biodiesel.reactor.application.port.output.DecanterPort
import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class DecanterService(
    private val decanterClient: DecanterClient,
    @Value("\${output.amount}")
    private val reactorOutputAmount: Double
): DecanterPort {
    private val logger = LoggerFactory.getLogger(DecanterService::class.java)

    override fun performDecanterSupply(reactor: Reactor): DecanterReactor =
        try {
            logger.info("Starting request to update reactor supply with $reactorOutputAmount L...")

            val decanterResponse = decanterClient.performSupplyDecanter(toRequest(reactorOutputAmount))

            decanterResponse.toDomain(reactor, reactorOutputAmount)
                .also {
                    logger.info("Finished request to update reactor supply OilTankReactor$it")
                }
        } catch (ex: FeignException) {
            throw ex
        }
}