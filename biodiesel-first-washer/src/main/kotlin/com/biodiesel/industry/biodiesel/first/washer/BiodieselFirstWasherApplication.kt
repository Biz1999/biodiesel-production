package com.biodiesel.industry.biodiesel.first.washer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
class BiodieselFirstWasherApplication

fun main(args: Array<String>) {
	runApplication<BiodieselFirstWasherApplication>(*args)
}
