package br.com.eguadorodrigo.kafkastarterproject.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NewOrderConsumer {

    @KafkaListener(topics = "ECOMMERCE_NEW_ORDER")
    public void processMessage(String content) {
        System.out.printf("NewOrderConsumer: %s\n", content);
    }

}
