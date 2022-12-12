package br.com.eguadorodrigo.kafkastarterproject.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NovoPedidoConsumer {

    @KafkaListener(topics = "LOJA_NOVO_PEDIDO")
    public void processMessage(String content) {
        System.out.printf("NovoPedidoConsumer: %s\n", content);
    }

}
