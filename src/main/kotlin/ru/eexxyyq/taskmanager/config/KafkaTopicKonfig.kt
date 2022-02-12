package ru.eexxyyq.taskmanager.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicKonfig {
    @Bean
    fun tasksTopic(): NewTopic = TopicBuilder.name("tasks").build()
}