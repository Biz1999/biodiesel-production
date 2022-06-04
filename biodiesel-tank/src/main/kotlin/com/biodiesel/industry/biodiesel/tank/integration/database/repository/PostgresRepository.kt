package com.biodiesel.industry.biodiesel.tank.integration.database.repository

import com.biodiesel.industry.biodiesel.tank.model.entity.BiodieselTankEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository: JpaRepository<BiodieselTankEntity, Long>