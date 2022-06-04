package com.biodiesel.industry.biodiesel.decanter.integration.database.postgres

import com.biodiesel.industry.biodiesel.decanter.integration.database.entity.DecanterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository: JpaRepository<DecanterEntity, Long>