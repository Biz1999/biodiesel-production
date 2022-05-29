package com.biodiesel.industry.biodiesel.naoh.tank.application.port.input

import com.biodiesel.industry.biodiesel.naoh.tank.application.domain.NaohTank

interface TankOutputUseCase {
    fun execute(): NaohTank
}