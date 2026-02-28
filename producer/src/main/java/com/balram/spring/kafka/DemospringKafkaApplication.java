package com.balram.spring.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class DemospringKafkaApplication {

	public final static String TOPIC_NAME = "demo-topic";

	//This quick tour works with the following versions:

	//	# Set Java environment
	//$env:JAVA_HOME="C:\path\.jdks\openjdk-25"
	//$env:PATH="$env:JAVA_HOME\bin;$env:PATH"
	//
	//# Go to Kafka folder
	//cd C:\path\kafka
	//
	//
	//PS C:\path\kafka> .\bin\windows\kafka-storage.bat random-uuid
	//2026-02-28T10:58:07.161464200Z main ERROR Reconfiguration failed: No configuration found for '764c12b6' at 'null' in 'null'
	//Pcnv95TYQmiDJr1_DxloBA
	//
	//PS C:\path\kafka> .\bin\windows\kafka-storage.bat format -t Pcnv95TYQmiDJr1_DxloBA -c .\config\kraft-server.properties
	//2026-02-28T10:58:53.354013Z main ERROR Reconfiguration failed: No configuration found for '764c12b6' at 'null' in 'null'
	//Formatting metadata directory C:/Users/Balram/kafka/kafka-logs with metadata.version 4.1-IV1.
	//
	//# Start Kafka
	//.\bin\windows\kafka-server-start.bat .\config\kraft-server.properties

	// To manage data effectively across a distributed system.
	// partitions are used to distribute data for increased parallelism and throughput
	// replicas are used to ensure data availability and fault tolerance

	@Bean
	NewTopic demoTopic(){
		return TopicBuilder
				.name(TOPIC_NAME)
				.partitions(10)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemospringKafkaApplication.class, args);
	}
}
