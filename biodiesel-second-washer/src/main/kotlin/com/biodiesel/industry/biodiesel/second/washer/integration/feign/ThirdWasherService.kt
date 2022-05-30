package com.biodiesel.industry.biodiesel.second.washer.integration.feign

import com.biodiesel.industry.biodiesel.second.washer.integration.feign.client.ThirdWasherClient
import com.biodiesel.industry.biodiesel.second.washer.integration.feign.converter.toRequest
import com.biodiesel.industry.biodiesel.second.washer.model.response.SupplyResponse
import org.springframework.stereotype.Service

@Service
class ThirdWasherService(
    private val thirdWasherClient: ThirdWasherClient
) {
    fun performSupply(amount: Double): SupplyResponse = thirdWasherClient.postSupply(toRequest(amount))
}