package com.biodiesel.industry.biodiesel.glycerin.tank.integration.database.repository

import com.biodiesel.industry.biodiesel.glycerin.tank.model.entity.GlycerinTankEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository: JpaRepository<GlycerinTankEntity, Long>