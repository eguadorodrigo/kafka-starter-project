package br.com.eguadorodrigo.kafkastarterproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaStarterProjectApplication {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaStarterProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(KafkaStarterProjectApplication.class);
        app.setLogStartupInfo(false);
        app.run(args);
    }

}
