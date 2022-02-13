package ru.eexxyyq.taskmanager.service.impl

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.eexxyyq.taskmanager.service.KafkaProducerService

@Service
class KafkaProducerServiceImpl(
    val kafkaTemplate: KafkaTemplate<String, String>
) : KafkaProducerService {

    override fun send(topic: String, data: String) {
        kafkaTemplate.send(topic, data)
    }
}