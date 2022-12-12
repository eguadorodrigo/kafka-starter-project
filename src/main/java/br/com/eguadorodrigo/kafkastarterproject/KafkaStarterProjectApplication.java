package br.com.eguadorodrigo.kafkastarterproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaStarterProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStarterProjectApplication.class, args);

		MyKafkaProducer.execute();	
		
	}

}
