package com.biodiesel.industry.biodiesel.reactor.application.service

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.reactor.application.domain.NaohSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.port.input.NaohSupplyReactorUseCase
import com.biodiesel.industry.biodiesel.reactor.application.service.converter.toDomain
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class NaohSupplyReactorService(
    private val reactorRepository: DatabaseRepository,
    @Value("\${naoh-supply.maximumAmount}")
    private val naohMaximumAmount: Double
): NaohSupplyReactorUseCase {
    private val logger = LoggerFactory.getLogger(NaohSupplyReactorService::class.java)

    override fun execute(naohSupply: NaohSupply): Reactor {
        logger.info("Starting process to supply reactor with NaOH. [EtohSupply=$naohSupply")

        naohSupply.isInvalidAmount()

        val reactor = reactorRepository.getReactor()

        if (reactor.status == Reactor.Status.UNAVAILABLE)
            throw IllegalArgumentException("Reactor can not receive EtOH now, UNAVAILABLE")
                .also {
                    logger.error("Reactor unavailable due to processing")
                }

        if (reactor.naohAmount >= naohMaximumAmount)
            throw IllegalArgumentException("EtOH limits can't be exceed")
                .also {
                    logger.error("EtOH supply limit reached")
                }

        val naohSupplyAmount = naohMaximumAmount - reactor.naohAmount

        return if (naohSupplyAmount >= naohSupply.amount) {
            reactorRepository.updateNaohSupply(reactor, naohSupply.amount).toDomain(reactor)
        } else {
            reactor.returnedAmount = naohSupply.amount - naohSupplyAmount
            reactorRepository.updateNaohSupply(reactor, naohSupplyAmount).toDomain(reactor)
        }.also {
            logger.info("Finished process to supply reactor with EtOH. [Reactor=$it")
        }
    }
}