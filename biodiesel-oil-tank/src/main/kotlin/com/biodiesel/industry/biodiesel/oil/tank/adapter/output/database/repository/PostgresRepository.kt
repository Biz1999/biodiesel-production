package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.repository

import com.biodiesel.industry.biodiesel.oil.tank.adapter.output.database.entity.OilTankEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository: JpaRepository<OilTankEntity, Long>