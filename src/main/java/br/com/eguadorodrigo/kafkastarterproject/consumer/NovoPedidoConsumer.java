package br.com.eguadorodrigo.kafkastarterproject.consumer;

import br.com.eguadorodrigo.kafkastarterproject.shared.KafkaConsumerBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "LOJA_NOVO_PEDIDO")
public class NovoPedidoConsumer implements KafkaConsumerBase {

    private static final Logger LOG = LoggerFactory.getLogger(NovoPedidoConsumer.class);
    @Override
    @KafkaHandler
    public void processMessage(String kafkaMessage) {
        LOG.info("KafkaHandler with message by String: {}", kafkaMessage);
    }

    @Override
    @KafkaHandler(isDefault = true)
    public void processObject(Object kafkaObject) {
        LOG.info("KafkaHandler with message by Object: {}", kafkaObject);
    }
}
