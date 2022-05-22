package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.helper

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.entity.OilTankEntity
import com.biodiesel.industry.biodiesel.oil.tank.application.domain.OilTank

fun OilTank.toEntitySupply(amount: Double): OilTankEntity = OilTankEntity(
    id = 0,
    amount = this.amount + amount,
    outputTime = outputTime
)

fun OilTank.toEntityOutput(amount: Double): OilTankEntity = OilTankEntity(
    id = 0,
    amount = this.amount + amount,
    supplyTime = supplyTime
)