package br.com.eguadorodrigo.kafkastarterproject.service;

import org.springframework.kafka.annotation.KafkaListener;

public class FraudDetectorService {

    @KafkaListener(topics = "ECOMMERCE_NEW_ORDER")
    public void processMessage(String content) {

        if(content != null){
            System.out.println("Content found! Processing new order");
        }
    }
    
}
