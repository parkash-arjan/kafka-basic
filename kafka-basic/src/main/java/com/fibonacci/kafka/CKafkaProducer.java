package com.fibonacci.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class CKafkaProducer {

	public static void main(String... args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");

		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);

		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("helloworld", null, "hello world again!");

		producer.send(producerRecord);

		producer.close();
	}
}
