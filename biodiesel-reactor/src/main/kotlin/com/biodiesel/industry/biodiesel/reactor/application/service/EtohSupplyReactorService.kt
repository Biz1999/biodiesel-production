package com.biodiesel.industry.biodiesel.reactor.application.service

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.reactor.application.domain.EtohSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.port.input.EtohSupplyReactorUseCase
import com.biodiesel.industry.biodiesel.reactor.application.service.converter.toDomain
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class EtohSupplyReactorService(
    private val reactorRepository: DatabaseRepository,
    @Value("\${etoh-supply.maximumAmount}")
    private val etohMaximumAmount: Double
): EtohSupplyReactorUseCase {
    private val logger = LoggerFactory.getLogger(EtohSupplyReactorService::class.java)

    override fun execute(etohSupply: EtohSupply): Reactor {
        logger.info("Starting process to supply reactor with EtOH. [EtohSupply=$etohSupply")

        etohSupply.isInvalidAmount()

        val reactor = reactorRepository.getReactor()

        if (reactor.status == Reactor.Status.UNAVAILABLE)
            throw IllegalArgumentException("Reactor can not receive EtOH now, UNAVAILABLE")
                .also {
                    logger.error("Reactor unavailable due to processing")
                }

        if (reactor.etohAmount >= etohMaximumAmount)
            throw IllegalArgumentException("EtOH limits can't be exceed")
                .also {
                    logger.error("EtOH supply limit reached")
                }

        val etohSupplyAmount = etohMaximumAmount - reactor.etohAmount

        return if (etohSupplyAmount >= etohSupply.amount) {
            reactorRepository.updateEtohSupply(reactor, etohSupply.amount).toDomain(reactor)
        } else {
            reactor.returnedAmount = etohSupply.amount - etohSupplyAmount
            reactorRepository.updateEtohSupply(reactor, etohSupplyAmount).toDomain(reactor)
        }.also {
            logger.info("Finished process to supply reactor with EtOH. [Reactor=$it")
        }
    }

}