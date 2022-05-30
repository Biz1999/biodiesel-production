package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.client.ReactorClient
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.converter.toDomain
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.converter.toRequest
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank
import com.biodiesel.industry.biodiesel.naoh.tank.application.dto.NaohTankReactor
import com.biodiesel.industry.biodiesel.naoh.tank.application.port.output.ReactorPort
import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ReactorService(
    private val reactorClient: ReactorClient,
    @Value("\${naoh-tank.output}")
    private val naohTankOutput: Double
): ReactorPort {
    private val logger = LoggerFactory.getLogger(ReactorService::class.java)

    override fun performReactorSupply(naohTank: NaohTank): NaohTankReactor =
        try {
            logger.info("Starting request to update reactor supply with ${naohTankOutput}L...")

            val naohTankSupply = reactorClient.createReactorSupply(toRequest(naohTankOutput))

            naohTankSupply.toDomain()
                .also {
                    logger.info("Finished request to update reactor supply $it")
                }
        } catch (ex: FeignException) {
            throw ex
        }
}