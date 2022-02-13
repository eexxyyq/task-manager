package ru.eexxyyq.taskmanager.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

@Configuration
class KafkaConsumerConfig(
    @Value("\${spring.kafka.bootstrap-servers}")
    private val bootstrapServiceUrl: String
) {

    fun consumerConfig(): Map<String, Any> {
        val map = mutableMapOf<String, Any>()
        map += ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServiceUrl
        map += ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        map += ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        return map
    }

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory(consumerConfig())
    }

    @Bean
    fun kafkaContainerFactory() : KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, String> =
            ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}