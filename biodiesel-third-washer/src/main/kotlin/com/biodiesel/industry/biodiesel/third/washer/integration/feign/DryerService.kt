package com.biodiesel.industry.biodiesel.third.washer.integration.feign

import com.biodiesel.industry.biodiesel.third.washer.integration.feign.client.DryerClient
import com.biodiesel.industry.biodiesel.third.washer.integration.feign.converter.toRequest
import com.biodiesel.industry.biodiesel.third.washer.model.response.SupplyResponse
import org.springframework.stereotype.Service

@Service
class DryerService(
    private val dryerClient: DryerClient
) {
    fun performSupply(amount: Double): SupplyResponse = dryerClient.postSupply(toRequest(amount))
}