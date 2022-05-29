package com.biodiesel.industry.biodiesel.dryer.integration.database.repository

import com.biodiesel.industry.biodiesel.dryer.model.entity.DryerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository : JpaRepository<DryerEntity, Long>