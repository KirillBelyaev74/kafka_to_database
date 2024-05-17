package ru.logging.kafka_to_database

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KafkaToDatabaseApplication

fun main(args: Array<String>) {
    runApplication<KafkaToDatabaseApplication>(*args)
}
