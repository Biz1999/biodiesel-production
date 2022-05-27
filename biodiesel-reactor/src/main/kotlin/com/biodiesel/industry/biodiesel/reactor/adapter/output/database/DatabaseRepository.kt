package com.biodiesel.industry.biodiesel.reactor.adapter.output.database

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.converter.toDomain
import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.converter.toOilDomain
import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.converter.toOilEntity
import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor.Status
import com.biodiesel.industry.biodiesel.reactor.application.dto.OilReactor
import com.biodiesel.industry.biodiesel.reactor.application.port.output.DatabasePort
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class DatabaseRepository(
    private val reactorRepository: PostgresRepository
): DatabasePort {
    private val logger = LoggerFactory.getLogger(DatabaseRepository::class.java)

    override fun getReactor(): Reactor {
        logger.info("Starting process to get reactor info with id=0...")

        return reactorRepository.getById(0).toDomain()
            .also {
                logger.info("Finished process to get reactor info. [ReactorEntity=$it]")
            }
    }

    override fun updateOilSupply(reactor: Reactor, amount: Double, status: Status): OilReactor {
        logger.info("Starting process to update reactor info with amount=$amount L...")

        return reactorRepository.save(reactor.toOilEntity(amount, status.name)).toOilDomain()
            .also {
                logger.info("Finished process to update reactor info with [OilReactor=${Gson().toJson(it)}")
            }
    }
}