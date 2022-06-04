package com.biodiesel.industry.biodiesel.etoh.tank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling


@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class BiodieselEtohTankApplication

fun main(args: Array<String>) {
	runApplication<BiodieselEtohTankApplication>(*args)
}
