package br.com.eguadorodrigo.kafkastarterproject.service;

import br.com.eguadorodrigo.kafkastarterproject.shared.KafkaConsumerBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(topics = "ECOMMERCE_SEND_EMAIL", groupId = "emailGroup")
public class EmailService implements KafkaConsumerBase {

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @Override
    @KafkaHandler
    public void processMessage(String kafkaMessage) {
        LOG.info("message with String:{}", kafkaMessage);
    }

    @Override
    @KafkaHandler
    public void processObject(Object kafkaObject) {
        LOG.info("message with Object:{}", kafkaObject);
    }
}
