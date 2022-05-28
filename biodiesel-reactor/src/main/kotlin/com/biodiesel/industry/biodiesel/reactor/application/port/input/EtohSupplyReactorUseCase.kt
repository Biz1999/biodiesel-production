package com.biodiesel.industry.biodiesel.reactor.application.port.input

import com.biodiesel.industry.biodiesel.reactor.application.domain.EtohSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor

interface EtohSupplyReactorUseCase {
    fun execute(etohSupply: EtohSupply): Reactor
}