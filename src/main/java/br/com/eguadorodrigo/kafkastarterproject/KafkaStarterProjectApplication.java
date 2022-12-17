package br.com.eguadorodrigo.kafkastarterproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaStarterProjectApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(KafkaStarterProjectApplication.class);
        app.setLogStartupInfo(false);
        app.run(args);
    }

}
