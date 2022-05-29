package com.biodiesel.industry.biodiesel.dryer.integration.database

import com.biodiesel.industry.biodiesel.dryer.integration.database.converter.toDomain
import com.biodiesel.industry.biodiesel.dryer.integration.database.converter.toEntityOutput
import com.biodiesel.industry.biodiesel.dryer.integration.database.converter.toEntitySupply
import com.biodiesel.industry.biodiesel.dryer.integration.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.dryer.model.Dryer
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val databaseRepository: PostgresRepository,
    @Value("\${output.amount}")
    private val dryerOutputAmount: Double
) {

    fun getDryer(): Dryer = databaseRepository.getById(0).toDomain()

    fun updateDryerAmountSupply(dryer: Dryer): Dryer =
        databaseRepository.save(dryer.toEntitySupply()).toDomain()

    fun updateDryerAmountOutput(dryer: Dryer): Dryer =
        databaseRepository.save(dryer.toEntityOutput(dryerOutputAmount)).toDomain()
}