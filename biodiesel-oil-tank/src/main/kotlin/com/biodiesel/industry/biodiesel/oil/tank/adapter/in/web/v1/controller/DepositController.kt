package com.biodiesel.industry.biodiesel.oil.tank.adapter.`in`.web.v1.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class DepositController {

    @GetMapping("/world")
    fun getHelloWorld(): String = "Hello World"
}