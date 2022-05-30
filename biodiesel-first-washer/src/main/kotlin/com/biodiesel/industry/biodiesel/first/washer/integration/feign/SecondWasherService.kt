package com.biodiesel.industry.biodiesel.first.washer.integration.feign

import com.biodiesel.industry.biodiesel.first.washer.integration.feign.client.SecondWasherClient
import com.biodiesel.industry.biodiesel.first.washer.integration.feign.converter.toRequest
import com.biodiesel.industry.biodiesel.first.washer.model.response.SupplyResponse
import org.springframework.stereotype.Service

@Service
class SecondWasherService(
    private val secondWasherClient: SecondWasherClient
) {
    fun performSupply(amount: Double): SupplyResponse = secondWasherClient.postSupply(toRequest(amount))
}