package com.biodiesel.industry.biodiesel.third.washer.integration.database

import com.biodiesel.industry.biodiesel.third.washer.integration.database.converter.toDomain
import com.biodiesel.industry.biodiesel.third.washer.integration.database.converter.toEntity
import com.biodiesel.industry.biodiesel.third.washer.integration.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.third.washer.model.Washer
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val databaseRepository: PostgresRepository
) {

    fun getWasher(): Washer = databaseRepository.getById(0).toDomain()

    fun updateWasher(washer: Washer, amount: Double, emulsion: Double): Washer =
        databaseRepository.save(washer.toEntity(amount, emulsion)).toDomain()
}