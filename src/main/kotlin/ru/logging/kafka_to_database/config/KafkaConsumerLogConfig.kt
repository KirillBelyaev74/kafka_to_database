package ru.logging.kafka_to_database.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import ru.logging.kafka_to_database.service.StoreRecordFilterStrategy

@Configuration
open class KafkaConsumerLogConfig {

    @Bean
    open fun consumerFactory(): ConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory(consumerConfigs())
    }

    @Bean
    open fun kafkaTemplate(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val template = ConcurrentKafkaListenerContainerFactory<String, String>()
        template.setRecordFilterStrategy(StoreRecordFilterStrategy())
        template.consumerFactory = consumerFactory()
        template.isBatchListener = true
        return template
    }

    @Bean
    open fun consumerConfigs(): Map<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ConsumerConfig.GROUP_ID_CONFIG] = StringSerializer::class.java
        return props
    }
}