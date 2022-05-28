package com.biodiesel.industry.biodiesel.reactor.application.service

import com.biodiesel.industry.biodiesel.reactor.application.domain.EtohSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.port.input.EtohSupplyReactorUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EtohSupplyReactorService: EtohSupplyReactorUseCase {
    private val logger = LoggerFactory.getLogger(EtohSupplyReactorService::class.java)

    override fun execute(etohSupply: EtohSupply): Reactor {
        TODO("Not yet implemented")
    }

}