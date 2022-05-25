package com.biodiesel.industry.biodiesel.oil.tank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class BiodieselOilTankApplication

fun main(args: Array<String>) {
	runApplication<BiodieselOilTankApplication>(*args)
}
