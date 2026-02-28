package com.balram.spring.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.RestController;

import static com.balram.spring.kafka.DemospringKafkaApplication.TOPIC_NAME;

@RestController
public class KafkaConsumer {

    @KafkaListener(id = "myId", topics = {TOPIC_NAME}, groupId = "demoGroups")
    public void listen(String record, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        System.out.println("Message: " + record + " Topic: " + topic + " Partition: " + partition + " Offset: " + offset);
    }
}
