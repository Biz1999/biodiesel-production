package com.biodiesel.industry.biodiesel.reactor.application.domain

data class NaohSupply(
    val amount: Double
){
    fun isInvalidAmount() {
        if(amount <= 0) throw IllegalArgumentException("Reactor can not receive invalid values")
    }
}
