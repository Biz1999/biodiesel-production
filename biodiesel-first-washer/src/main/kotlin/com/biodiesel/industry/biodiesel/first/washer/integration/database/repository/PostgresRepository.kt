package com.biodiesel.industry.biodiesel.first.washer.integration.database.repository

import com.biodiesel.industry.biodiesel.first.washer.model.entity.WasherEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository : JpaRepository<WasherEntity, Long>