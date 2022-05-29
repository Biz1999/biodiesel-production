package com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.repository

import com.biodiesel.industry.biodiesel.etoh.dryer.model.entity.EtohDryerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository : JpaRepository<EtohDryerEntity, Long>