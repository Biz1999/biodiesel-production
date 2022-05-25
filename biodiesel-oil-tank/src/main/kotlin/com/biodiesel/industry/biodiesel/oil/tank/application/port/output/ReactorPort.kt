package com.biodiesel.industry.biodiesel.oil.tank.application.port.output

import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank
import com.biodiesel.industry.biodiesel.oil.tank.application.dto.OilTankReactor

interface ReactorPort {

    fun performReactorSupply(oilTank: OilTank): OilTankReactor
}