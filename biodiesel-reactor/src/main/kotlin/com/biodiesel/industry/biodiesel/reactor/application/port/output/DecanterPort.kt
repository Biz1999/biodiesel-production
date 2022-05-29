package com.biodiesel.industry.biodiesel.reactor.application.port.output

import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.DecanterReactor

interface DecanterPort {
    fun performDecanterSupply(reactor: Reactor): DecanterReactor
}