package com.balram.springbatch.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import static com.balram.springbatch.kafka.DemoSpringBatchKafkaApplication.TOPIC_NAME;

@RestController
public class Listen {

    @KafkaListener(id = "myId", topics = { TOPIC_NAME })
    public void listen(String in) {
        System.out.println(in);
    }
}
