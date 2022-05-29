package com.biodiesel.industry.biodiesel.reactor.application.service

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.reactor.application.domain.OilSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.port.input.OilSupplyReactorUseCase
import com.biodiesel.industry.biodiesel.reactor.application.service.converter.toDomain
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
        logger.info("Starting process to supply reactor with oil. [OilSupply=$oilSupply")

        oilSupply.isInvalidAmount()

        val reactor = reactorRepository.getReactor()

        if (reactor.status == Reactor.Status.UNAVAILABLE)
            throw IllegalArgumentException("Reactor can not receive oil now, UNAVAILABLE")
                .also {
                    logger.error("Reactor unavailable due to processing")
                }

        if (reactor.oilAmount >= oilMaximumAmount)
            throw IllegalArgumentException("Oil limits can't be exceed")
                .also {
                logger.error("Oil supply limit reached")
            }

        val oilSupplyAmount = oilMaximumAmount - reactor.oilAmount

        return if (oilSupplyAmount >= oilSupply.amount) {
            reactorRepository.updateOilSupply(reactor, oilSupply.amount).toDomain(reactor)
        } else {
            reactor.returnedAmount = oilSupply.amount - oilSupplyAmount
            reactorRepository.updateOilSupply(reactor, oilSupplyAmount).toDomain(reactor)
        }.also {
            logger.info("Finished process to supply reactor with oil. [Reactor=$it")
        }
    }
}