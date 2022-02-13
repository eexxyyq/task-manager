package ru.eexxyyq.taskmanager.service

interface KafkaProducerService {
    fun send(topic: String, data: String)
}