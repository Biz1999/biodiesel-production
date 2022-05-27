package com.biodiesel.industry.biodiesel.reactor.application.service

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.reactor.application.domain.OilSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.port.input.OilSupplyReactorUseCase
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class OilSupplyReactorService(
    private val reactorRepository: DatabaseRepository,
    @Value("\${oil-supply.maximumAmount}")
    private val oilMaximumAmount: Double
): OilSupplyReactorUseCase {
    private val logger = LoggerFactory.getLogger(OilSupplyReactorService::class.java)

    override fun execute(oilSupply: OilSupply): Reactor {
        logger.info("Starting process to supply reactor with oil. [OilSupply=${Gson().toJson(oilSupply)}")

        val reactor = reactorRepository.getReactor()
        reactor.returnedAmount = 1.0

        return reactor.takeIf { reactor.oilAmount < oilMaximumAmount }
            ?: throw IllegalArgumentException("Oil limits can't be exceed").also {
                logger.error("Oil supply limit reached")
            }
    }
}