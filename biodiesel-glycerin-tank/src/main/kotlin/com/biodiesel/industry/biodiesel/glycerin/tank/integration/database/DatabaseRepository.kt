package com.biodiesel.industry.biodiesel.glycerin.tank.integration.database

import com.biodiesel.industry.biodiesel.glycerin.tank.integration.database.converter.toDomain
import com.biodiesel.industry.biodiesel.glycerin.tank.integration.database.converter.toEntity
import com.biodiesel.industry.biodiesel.glycerin.tank.integration.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.glycerin.tank.model.GlycerinTank
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val databaseRepository: PostgresRepository
) {
    fun getBiodieselTank(): GlycerinTank =
        databaseRepository.getById(0).toDomain()

    fun updateBiodieselTank(glycerinTank: GlycerinTank): GlycerinTank =
        databaseRepository.save(glycerinTank.toEntity()).toDomain()
}