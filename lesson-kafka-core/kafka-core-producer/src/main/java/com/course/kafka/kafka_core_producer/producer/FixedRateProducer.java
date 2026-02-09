package com.course.kafka.kafka_core_producer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateProducer {

    private static final Logger LOG = LoggerFactory.getLogger(FixedRateProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public FixedRateProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private int i = 0;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        i++;
        LOG.info("i is {}", i);
        kafkaTemplate.send("t-fixedrate", "Fixed rate " + i);
    }
}
