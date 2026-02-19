package com.course.kafka.kafka_core_consumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KafkaKeyConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaKeyConsumer.class);

    @KafkaListener(topics = "t-multi-partitions",concurrency = "4")
    public void consumeMessage(ConsumerRecord<String, String> record) throws InterruptedException {
        logger.info("key: {}, partition: {}, Message: {}", record.key(), record.partition(), record.value());
        TimeUnit.SECONDS.sleep(1);
    }
}
