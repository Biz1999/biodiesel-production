package com.biodiesel.industry.biodiesel.etoh.dryer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class BiodieselEtohDryerApplication

fun main(args: Array<String>) {
	runApplication<BiodieselEtohDryerApplication>(*args)
}
