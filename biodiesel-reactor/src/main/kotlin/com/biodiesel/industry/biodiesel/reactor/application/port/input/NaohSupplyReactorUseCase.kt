package com.biodiesel.industry.biodiesel.reactor.application.port.input

import com.biodiesel.industry.biodiesel.reactor.application.domain.NaohSupply
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor

interface NaohSupplyReactorUseCase {
    fun execute(naohSupply: NaohSupply): Reactor
}