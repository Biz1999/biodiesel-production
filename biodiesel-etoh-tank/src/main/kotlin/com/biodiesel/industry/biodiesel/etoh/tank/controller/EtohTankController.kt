//package com.biodiesel.industry.biodiesel.etoh.tank.controller
//
//import com.biodiesel.industry.biodiesel.etoh.tank.controller.response.TankOutputResponse
//import com.biodiesel.industry.biodiesel.etoh.tank.controller.response.TankSupplyResponse
//import com.biodiesel.industry.biodiesel.etoh.tank.integration.database.DatabaseRepository
//import com.biodiesel.industry.biodiesel.etoh.tank.service.TankSupplyService
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.http.HttpStatus
//import org.springframework.scheduling.annotation.Scheduled
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.ResponseStatus
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/v1")
//class EtohTankController(
//    private val tankSupplyService: TankSupplyService
//) {
//
//    @PostMapping("/supply")
//    @ResponseStatus(HttpStatus.CREATED)
//    fun postSupply(): TankSupplyResponse {
//        tankSupplyService.supplyEtohTank()
//    }
//
//
//
//
//    @PostMapping("/output")
//    @ResponseStatus(HttpStatus.OK)
//    fun postOutput(): TankOutputResponse{}
//
//
//}