package br.com.eguadorodrigo.kafkastarterproject.consumer;

import br.com.eguadorodrigo.kafkastarterproject.config.KafkaProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import br.com.eguadorodrigo.kafkastarterproject.shared.TopicsConstants;

import java.util.UUID;

public class NewOrderProducer {
    private static final KafkaProducerConfig kafkaProducerConfig = new KafkaProducerConfig(new KafkaProperties());

    public static void main(String[] args) {

        var key = UUID.randomUUID().toString();
        var newOrderMessage = "New Order via app Producer";
        var emailMessage = "Email via app Producer";

        var newOrderRecord = new ProducerRecord<>(TopicsConstants.ECOMMERCE_NEW_ORDER, key, newOrderMessage);
        var emailRecord = new ProducerRecord<>(TopicsConstants.ECOMMERCE_SEND_EMAIL, key, emailMessage);

        kafkaProducerConfig.kafkaTemplate().send(newOrderRecord);
        kafkaProducerConfig.kafkaTemplate().send(emailRecord);

    }
}
