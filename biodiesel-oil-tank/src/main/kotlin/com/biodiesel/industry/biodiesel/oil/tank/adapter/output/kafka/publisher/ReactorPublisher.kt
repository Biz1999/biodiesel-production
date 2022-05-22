package com.biodiesel.industry.biodiesel.oil.tank.adapter.output.kafka.publisher

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ReactorPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${topic.name.producer}")
    private val topicName: String
) {
    private val logger = LoggerFactory.getLogger(ReactorPublisher::class.java)

    fun send(message: String): Unit{
        logger.info("Payload enviado para $topicName. Payload=$message")

        kafkaTemplate.send(topicName, message)

        logger.info("Payload enviado com sucesso!")
    }
}