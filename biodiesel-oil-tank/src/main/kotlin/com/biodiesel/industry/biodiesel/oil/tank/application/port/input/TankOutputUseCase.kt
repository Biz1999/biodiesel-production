package com.biodiesel.industry.biodiesel.oil.tank.application.port.input

import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank

interface TankOutputUseCase {
    fun execute(): OilTank
}