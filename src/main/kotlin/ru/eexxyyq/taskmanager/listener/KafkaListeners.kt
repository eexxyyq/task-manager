package ru.eexxyyq.taskmanager.listener

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaListeners(
    val objectMapper: ObjectMapper,

) {
    val logger: Logger = LoggerFactory.getLogger(KafkaListeners::class.java)

    @KafkaListener(
        topics = ["tasks"],
        groupId = "task-manager_2"
    )
    fun listenerTask(data: String) {
        logger.info(data)
    }
}