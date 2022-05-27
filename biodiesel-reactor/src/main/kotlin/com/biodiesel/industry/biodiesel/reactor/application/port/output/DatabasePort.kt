package com.biodiesel.industry.biodiesel.reactor.application.port.output

import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor.Status
import com.biodiesel.industry.biodiesel.reactor.application.dto.OilReactor

interface DatabasePort {

    fun getReactor(): Reactor

    fun updateOilSupply(reactor: Reactor, amount: Double, status: Status): OilReactor
}