package ru.logging.kafka_to_database.service

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.listener.adapter.RecordFilterStrategy

open class StoreRecordFilterStrategy : RecordFilterStrategy<String, String> {

    override fun filter(consumerRecord: ConsumerRecord<String, String>): Boolean {
        println("svhadfjklmsv")
        println(consumerRecord.toString())
        return false
    }
}