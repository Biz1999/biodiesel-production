package com.biodiesel.industry.biodiesel.tank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class BiodieselTankApplication

fun main(args: Array<String>) {
	runApplication<BiodieselTankApplication>(*args)
}
