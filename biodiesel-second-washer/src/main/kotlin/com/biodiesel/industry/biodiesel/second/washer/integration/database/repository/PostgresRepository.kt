package com.biodiesel.industry.biodiesel.second.washer.integration.database.repository

import com.biodiesel.industry.biodiesel.second.washer.model.entity.WasherEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository : JpaRepository<WasherEntity, Long>