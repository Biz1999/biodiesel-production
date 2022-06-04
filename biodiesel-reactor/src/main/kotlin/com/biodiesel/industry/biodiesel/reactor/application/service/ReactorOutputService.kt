package com.biodiesel.industry.biodiesel.reactor.application.service

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor.Status.AVAILABLE
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor.Status.UNAVAILABLE
import com.biodiesel.industry.biodiesel.reactor.application.dto.DecanterReactor
import com.biodiesel.industry.biodiesel.reactor.application.port.input.ReactorOutputUseCase
import com.biodiesel.industry.biodiesel.reactor.application.port.output.DecanterPort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ReactorOutputService(
    private val reactorRepository: DatabaseRepository,
    private val decanterPort: DecanterPort
) : ReactorOutputUseCase {
    private val logger = LoggerFactory.getLogger(ReactorOutputService::class.java)

    override fun execute(): Reactor {
        logger.info("Starting process to supply decanter...")

        val reactor = reactorRepository.getReactor()

        if(reactor.amount.equals(0.0))
            throw IllegalArgumentException("Reactor is empty")

        if(reactor.isNotProportional())
            throw IllegalArgumentException("Reactor is not proportional")
                .also {
                    logger.error("Reactor is not proportional")
                }

        val decanterReactor = decanterPort.performDecanterSupply(reactor)

        return reactorRepository.updateReactorAmount(reactor.updateOutput(decanterReactor))
            .also {
                logger.info("Finished process to update reactor to decanter. [Reactor=$it]")
            }
    }

    private fun Reactor.isNotProportional(): Boolean =
        !(oilAmount.equals(amount / 2) && etohAmount.equals(amount / 4) && naohAmount.equals(amount / 4))

    private fun Reactor.updateOutput(decanterReactor: DecanterReactor): Reactor = Reactor(
        amount = decanterReactor.amount,
        status = if (decanterReactor.amount == 0.0) AVAILABLE else UNAVAILABLE,
        oilAmount = decanterReactor.oilAmount,
        naohAmount = decanterReactor.naohAmount,
        etohAmount = decanterReactor.etohAmount,
        oilSupplyTime = oilSupplyTime,
        etohSupplyTime = etohSupplyTime,
        naohSupplyTime = naohSupplyTime,
        outputTime = decanterReactor.supplyTime
    )

}