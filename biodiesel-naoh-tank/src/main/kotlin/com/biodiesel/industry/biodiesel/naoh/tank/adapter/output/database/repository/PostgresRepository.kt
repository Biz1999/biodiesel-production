package com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.repository

import com.biodiesel.industry.biodiesel.naoh.tank.adapter.output.database.entity.NaohTankEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository: JpaRepository<NaohTankEntity, Long>