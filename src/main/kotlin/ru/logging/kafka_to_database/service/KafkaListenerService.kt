package ru.logging.kafka_to_database.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
open class KafkaListenerService {

    @KafkaListener(topics = ["\${spring.kafka.topic.store_rest.name}"], groupId = "\${spring.kafka.topic.store_rest.name}")
    open fun store_rest(message: String) {
        println(message)
    }

    @KafkaListener(topics = ["\${spring.kafka.topic.store_thing.name}"], groupId = "\${spring.kafka.topic.store_thing.name}")
    open fun store_thing(message: String) {
        println(message)
    }

    @KafkaListener(topics = ["\${spring.kafka.topic.store_user.name}"], groupId = "\${spring.kafka.topic.store_user.name}")
    open fun store_user(message: String) {
        println(message)
    }
}