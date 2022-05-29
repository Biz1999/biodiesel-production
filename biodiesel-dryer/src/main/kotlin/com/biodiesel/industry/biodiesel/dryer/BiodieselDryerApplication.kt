package com.biodiesel.industry.biodiesel.dryer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class BiodieselDryerApplication

fun main(args: Array<String>) {
	runApplication<BiodieselDryerApplication>(*args)
}
