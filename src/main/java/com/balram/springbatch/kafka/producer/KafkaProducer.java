package com.balram.springbatch.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.balram.springbatch.kafka.DemoSpringBatchKafkaApplication.TOPIC_NAME;

@RestController
public class KafkaProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "publish")
    public void publish(){
        kafkaTemplate.send(TOPIC_NAME, ""+Math.random());
    }
}

