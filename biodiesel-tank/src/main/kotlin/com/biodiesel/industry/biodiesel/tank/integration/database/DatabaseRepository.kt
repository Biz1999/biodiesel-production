package com.biodiesel.industry.biodiesel.tank.integration.database

import com.biodiesel.industry.biodiesel.tank.integration.database.converter.toDomain
import com.biodiesel.industry.biodiesel.tank.integration.database.converter.toEntity
import com.biodiesel.industry.biodiesel.tank.integration.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.tank.model.BiodieselTank
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val databaseRepository: PostgresRepository
) {
    fun getBiodieselTank(): BiodieselTank =
        databaseRepository.getById(0).toDomain()

    fun updateBiodieselTank(biodieselTank: BiodieselTank): BiodieselTank =
        databaseRepository.save(biodieselTank.toEntity()).toDomain()
}