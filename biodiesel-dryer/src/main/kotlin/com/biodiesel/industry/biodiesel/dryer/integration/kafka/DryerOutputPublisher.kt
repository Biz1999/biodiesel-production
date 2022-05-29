package com.biodiesel.industry.biodiesel.dryer.integration.kafka

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate

@Configuration
class DryerOutputPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${topic.name.biodiesel.publisher}")
    private val topicName: String
) {
    private val logger = LoggerFactory.getLogger(DryerOutputPublisher::class.java)

    fun publishMessage(message: String) {
        logger.info("Payload sent to $topicName. Payload=$message")

        kafkaTemplate.send(topicName, message)

        logger.info("Payload sent succeeded!")
    }
}