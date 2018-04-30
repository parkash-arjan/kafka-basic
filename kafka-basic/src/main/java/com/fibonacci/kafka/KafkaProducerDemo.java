package com.fibonacci.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerDemo {

	public void sendMessage(String topic, String partitionKey, String message) {

		Properties properties = new Properties();

		// kafka bootstrap server
		properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		// producer acks
		properties.setProperty("acks", "1");
		properties.setProperty("retries", "3");
		properties.setProperty("linger.ms", "1");

		Producer<String, String> producer = new KafkaProducer<String, String>(properties);

		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, partitionKey, message);

		producer.send(producerRecord);
		producer.close();

	}

}
