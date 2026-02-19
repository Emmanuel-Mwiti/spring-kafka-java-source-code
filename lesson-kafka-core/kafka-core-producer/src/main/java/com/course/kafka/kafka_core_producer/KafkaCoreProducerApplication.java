package com.course.kafka.kafka_core_producer;

import com.course.kafka.kafka_core_producer.producer.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
//@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {

    @Autowired
    private KafkaKeyProducer kafkaKeyProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaCoreProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10_000; i++) {
            String key = "key-" + i;
            String value = "Message-" + i;
            kafkaKeyProducer.sendMessage(key, value);

//            TimeUnit.SECONDS.sleep(1);
        }
    }

}
