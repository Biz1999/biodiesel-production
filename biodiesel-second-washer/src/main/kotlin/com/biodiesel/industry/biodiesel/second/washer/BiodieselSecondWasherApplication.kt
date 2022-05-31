package com.biodiesel.industry.biodiesel.second.washer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling


@EnableFeignClients
@EnableScheduling
@SpringBootApplication
class BiodieselSecondWasherApplication

fun main(args: Array<String>) {
	runApplication<BiodieselSecondWasherApplication>(*args)
}
