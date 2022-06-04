package com.biodiesel.industry.biodiesel.reactor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class BiodieselReactorApplication

fun main(args: Array<String>) {
	runApplication<BiodieselReactorApplication>(*args)
}
