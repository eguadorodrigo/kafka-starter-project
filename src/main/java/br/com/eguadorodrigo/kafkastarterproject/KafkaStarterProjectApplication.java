package br.com.eguadorodrigo.kafkastarterproject;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.eguadorodrigo.kafkastarterproject.producer.NewOrderProducer;
import br.com.eguadorodrigo.kafkastarterproject.producer.NovoPedidoProducer;
import br.com.eguadorodrigo.kafkastarterproject.producer.QuickStartProducer;

@SpringBootApplication
public class KafkaStarterProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStarterProjectApplication.class, args);

		try {
			QuickStartProducer.execute();
			NewOrderProducer.execute();
			NovoPedidoProducer.execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}	
		
	}

}
