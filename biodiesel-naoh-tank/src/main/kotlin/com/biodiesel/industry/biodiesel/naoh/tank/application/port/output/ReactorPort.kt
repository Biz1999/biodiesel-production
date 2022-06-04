package com.biodiesel.industry.biodiesel.naoh.tank.application.port.output

import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank
import com.biodiesel.industry.biodiesel.naoh.tank.application.dto.NaohTankReactor

interface ReactorPort {

    fun performReactorSupply(naohTank: NaohTank): NaohTankReactor
}