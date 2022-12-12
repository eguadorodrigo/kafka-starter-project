package br.com.eguadorodrigo.kafkastarterproject.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class QuickStartConsumer {

    @KafkaListener(topics = "quickstart")
    public void processMessage(String content) {
        System.out.printf("QuickStartConsumer: %s\n", content);
    }

}
