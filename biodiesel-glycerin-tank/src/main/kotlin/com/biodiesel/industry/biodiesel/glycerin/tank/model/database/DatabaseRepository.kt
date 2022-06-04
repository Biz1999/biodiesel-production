package com.biodiesel.industry.biodiesel.glycerin.tank.model.database

import com.biodiesel.industry.biodiesel.glycerin.tank.model.database.converter.toDomain
import com.biodiesel.industry.biodiesel.glycerin.tank.model.database.converter.toEntity
import com.biodiesel.industry.biodiesel.glycerin.tank.model.database.repository.PostgresRepository
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