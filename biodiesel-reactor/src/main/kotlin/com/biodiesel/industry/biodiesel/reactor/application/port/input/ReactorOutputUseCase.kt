package com.biodiesel.industry.biodiesel.reactor.application.port.input

import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor

interface ReactorOutputUseCase {

    fun execute(): Reactor
}