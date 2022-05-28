package com.biodiesel.industry.biodiesel.reactor.adapter.output.database

import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.converter.*
import com.biodiesel.industry.biodiesel.reactor.adapter.output.database.repository.PostgresRepository
import com.biodiesel.industry.biodiesel.reactor.application.domain.Reactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.EtohReactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.NaohReactor
import com.biodiesel.industry.biodiesel.reactor.application.dto.OilReactor
import com.biodiesel.industry.biodiesel.reactor.application.port.output.DatabasePort
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

    override fun updateOilSupply(reactor: Reactor, amount: Double): OilReactor {
        logger.info("Starting process to update reactor info with amount=$amount L...")

        return reactorRepository.save(reactor.toOilEntity(amount)).toOilDomain()
            .also {
                logger.info("Finished process to update reactor info with [OilReactor=${it}")
            }
    }

    override fun updateEtohSupply(reactor: Reactor, amount: Double): EtohReactor {
        logger.info("Starting process to update reactor info with amount=$amount L...")

        return reactorRepository.save(reactor.toEtohEntity(amount)).toEtohDomain()
            .also {
                logger.info("Finished process to update reactor info with [OilReactor=${it}")
            }
    }

    override fun updateNaohSupply(reactor: Reactor, amount: Double): NaohReactor {
        logger.info("Starting process to update reactor info with amount=$amount L...")

        return reactorRepository.save(reactor.toNaohEntity(amount)).toNaohDomain()
            .also {
                logger.info("Finished process to update reactor info with [OilReactor=${it}")
            }
    }

    override fun updateReactorAmount(reactor: Reactor): Reactor {
        logger.info("Starting process to remove amount from reactor. [Reactor=$reactor]")

        return reactorRepository.save(reactor.toEntity()).toDomain()
            .also {
                logger.info("Finished process to remove reactor amount with response [Reactor=$it")
            }
    }
}