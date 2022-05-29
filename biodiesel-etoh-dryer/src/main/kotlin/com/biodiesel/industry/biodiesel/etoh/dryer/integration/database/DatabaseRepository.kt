package com.biodiesel.industry.biodiesel.etoh.dryer.integration.database

import com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.converter.toDomain
import com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.converter.toEntityOutput
import com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.converter.toEntitySupply
import com.biodiesel.industry.biodiesel.etoh.dryer.integration.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.etoh.dryer.model.EtohDryer
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val databaseRepository: PostgresRepository,
    @Value("\${output.amount}")
    private val dryerOutputAmount: Double
) {

    fun getEtohDryer(): EtohDryer = databaseRepository.getById(0).toDomain()

    fun updateEtohDryerAmountSupply(etohDryer: EtohDryer): EtohDryer =
        databaseRepository.save(etohDryer.toEntitySupply()).toDomain()

    fun updateEtohDryerAmountOutput(etohDryer: EtohDryer): EtohDryer =
        databaseRepository.save(etohDryer.toEntityOutput(dryerOutputAmount)).toDomain()
}