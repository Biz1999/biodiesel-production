package com.biodiesel.industry.biodiesel.oil.tank.application.service

import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank

interface TankOutputUseCase {
    fun execute(): OilTank
}