package com.euler.spring.kafka.kafkabasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fibonacci.kafka.KafkaProducerDemo;

@ComponentScan({ "com.fibonacci.kafka" })
@SpringBootApplication
public class KafkaBasicApplication implements CommandLineRunner {

	//Adding comment to existing code.
	@Autowired
	KafkaProducerDemo kafkaProducerDemo;

	public static void main(String[] args) {
		SpringApplication.run(KafkaBasicApplication.class, args);
	}  

	@Override
	public void run(String... args) throws Exception {
		kafkaProducerDemo.sendMessage("first-kafka-topic", "Key1", "Hello this is message from Java API....");

	}

}
