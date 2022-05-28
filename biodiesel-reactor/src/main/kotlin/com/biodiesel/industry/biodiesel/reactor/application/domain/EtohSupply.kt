package com.biodiesel.industry.biodiesel.reactor.application.domain

data class EtohSupply(
    val amount: Double
){
    fun isInvalidAmount() {
        if(amount <= 0) throw IllegalArgumentException("Reactor can not receive invalid values")
    }
}
