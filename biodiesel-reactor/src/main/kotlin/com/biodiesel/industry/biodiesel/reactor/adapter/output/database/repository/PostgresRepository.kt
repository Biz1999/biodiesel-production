package com.biodiesel.industry.biodiesel.reactor.adapter.output.database.repository

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.entity.ReactorEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresRepository: JpaRepository<ReactorEntity, Long>