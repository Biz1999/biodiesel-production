package com.biodiesel.industry.biodiesel.oil.tank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableKafka
@SpringBootApplication
class BiodieselOilTankApplication

fun main(args: Array<String>) {
	runApplication<BiodieselOilTankApplication>(*args)
}
