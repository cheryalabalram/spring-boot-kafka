package com.balram.springbatch.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class DemoSpringBatchKafkaApplication {

	public final static String TOPIC_NAME = "demo-topic";


	//https://docs.spring.io/spring-kafka/docs/3.1.2/reference/quick-tour.html

	//This quick tour works with the following versions:
	//Apache Kafka Clients 3.6.x
	//Spring Framework 6.1.x
	//Minimum Java version: 17

	//.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
	//.\bin\windows\kafka-server-start.bat .\config\server.properties
	//.\bin\windows\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092
	//.\bin\windows\kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092
	//.\bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
	//.\bin\windows\kafka-console-consumer.bat --topic quickstart-events --bootstrap-server localhost:9092 --from-beginning

	// To manage data effectively across a distributed system.
	// partitions are used to distribute data for increased parallelism and throughput
	// replicas are used to ensure data availability and fault tolerance

	@Bean
	NewTopic demoTopic(){
		return TopicBuilder.name(TOPIC_NAME).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBatchKafkaApplication.class, args);
	}
}
