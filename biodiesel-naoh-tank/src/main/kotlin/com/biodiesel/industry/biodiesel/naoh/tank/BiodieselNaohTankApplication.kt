package com.biodiesel.industry.biodiesel.naoh.tank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class BiodieselNaohTankApplication

fun main(args: Array<String>) {
	runApplication<BiodieselNaohTankApplication>(*args)
}
