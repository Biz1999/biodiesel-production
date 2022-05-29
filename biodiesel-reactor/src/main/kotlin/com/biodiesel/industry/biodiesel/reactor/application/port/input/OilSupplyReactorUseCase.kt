package com.biodiesel.industry.biodiesel.reactor.application.port.input

import com.biodiesel.industry.biodiesel.reactor.application.domain.OilSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor

interface OilSupplyReactorUseCase {
    fun execute(oilSupply: OilSupply): Reactor
}