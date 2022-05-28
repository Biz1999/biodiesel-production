package com.biodiesel.industry.biodiesel.reactor.application.port.output

import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor.Status
import com.biodiesel.industry.biodiesel.reactor.application.dto.EtohReactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.NaohReactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.OilReactor

interface DatabasePort {

    fun getReactor(): Reactor

    fun updateOilSupply(reactor: Reactor, amount: Double): OilReactor

    fun updateEtohSupply(reactor: Reactor, amount: Double): EtohReactor

    fun updateNaohSupply(reactor: Reactor, amount: Double): NaohReactor

    fun updateReactorAmount(reactor: Reactor): Reactor
}