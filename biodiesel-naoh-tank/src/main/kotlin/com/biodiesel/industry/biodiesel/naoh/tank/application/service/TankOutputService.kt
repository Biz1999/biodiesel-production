package com.biodiesel.industry.biodiesel.naoh.tank.application.service

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.DatabaseRepository
import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.feign.reactor.ReactorService
import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank
import com.biodiesel.industry.biodiesel.naoh.tank.application.port.input.TankOutputUseCase
import com.biodiesel.industry.biodiesel.naoh.tank.application.port.output.ReactorPort
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TankOutputService(
    private val naohTankRepository: DatabaseRepository,
    private val reactorPort: ReactorPort,
    @Value("\${naoh-tank.output}")
    private val naohTankOutput: Double
    ) : TankOutputUseCase {

        private val logger = LoggerFactory.getLogger(TankOutputService::class.java)

        override fun execute(): NaohTank {
            val naohTank = naohTankRepository.getNaohTank()

            if (naohTank.amount <= naohTankOutput)
                throw IllegalArgumentException("Insufficient amount in NaOH tank = ${naohTank.amount}L")

            logger.info("Starting process to supply reactor information with ${-naohTankOutput} L")

            val naohTankReactor = reactorPort.performReactorSupply(naohTank)

            return naohTankRepository.updateTankAmountByOutput(naohTankOutput - naohTankReactor.amount, naohTank)
                .also {
                    logger.info("Finished process to supply reactor information. Tank=$it")
                }
        }
}