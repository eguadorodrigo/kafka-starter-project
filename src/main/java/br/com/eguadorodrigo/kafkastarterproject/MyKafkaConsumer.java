package br.com.eguadorodrigo.kafkastarterproject;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaConsumer {

    public MyKafkaConsumer(KafkaTemplate<String, String> kafkaTemplate) {
    }

    @KafkaListener(topics = "quickstart")
    public void processMessage(String content) {
        System.out.printf("%s\n", content);
    }

}
