package br.com.eguadorodrigo.kafkastarterproject.consumer;

import br.com.eguadorodrigo.kafkastarterproject.shared.KafkaConsumerBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "ECOMMERCE_NEW_ORDER")
public class NewOrderConsumer implements KafkaConsumerBase {
    private static final Logger LOG = LoggerFactory.getLogger(NewOrderConsumer.class);

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
