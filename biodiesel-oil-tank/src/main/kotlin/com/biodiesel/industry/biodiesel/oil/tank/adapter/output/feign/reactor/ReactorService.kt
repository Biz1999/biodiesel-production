package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.client.ReactorClient
import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.converter.toDomain
import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.feign.reactor.converter.toRequest
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank
import com.biodiesel.industry.biodiesel.oil.tank.application.dto.OilTankReactor
import com.biodiesel.industry.biodiesel.oil.tank.application.port.output.ReactorPort
import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ReactorService(
    private val reactorClient: ReactorClient
): ReactorPort {
    private val logger = LoggerFactory.getLogger(ReactorService::class.java)

    override fun performReactorSupply(oilTank: OilTank): OilTankReactor =
        try {
            logger.info("Starting request to update reactor supply with ${oilTank.amount}L...")

            val oilTankSupply = reactorClient.createReactorSupply(oilTank.toRequest())

            oilTankSupply.toDomain()
                .also {
                    logger.info("Finished request to update reactor supply OilTankReactor$it")
                }
        } catch (ex: FeignException) {
            throw ex
        }
}