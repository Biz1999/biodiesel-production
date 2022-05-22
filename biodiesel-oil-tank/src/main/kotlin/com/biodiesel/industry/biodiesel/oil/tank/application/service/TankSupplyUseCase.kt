package com.biodiesel.industry.biodiesel.oil.tank.application.service

import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank

interface TankSupplyUseCase {

    fun execute(amount: Double): OilTank
}