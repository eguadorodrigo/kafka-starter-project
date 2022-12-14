package br.com.eguadorodrigo.kafkastarterproject;

import br.com.eguadorodrigo.kafkastarterproject.producer.NewOrderProducer;
import br.com.eguadorodrigo.kafkastarterproject.producer.NovoPedidoProducer;
import br.com.eguadorodrigo.kafkastarterproject.producer.QuickStartProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class KafkaStarterProjectApplication {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaStarterProjectApplication.class);


    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(KafkaStarterProjectApplication.class);
		app.setLogStartupInfo(false);
        app.run(args);

        try {
            QuickStartProducer.execute();
            NewOrderProducer.execute();
            NovoPedidoProducer.execute();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
	}

}
