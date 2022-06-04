package com.biodiesel.industry.biodiesel.etoh.tank.integration.database.postgres

import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.entity.EtohTankEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository: JpaRepository<EtohTankEntity, Long>