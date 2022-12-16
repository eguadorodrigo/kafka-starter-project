package br.com.eguadorodrigo.kafkastarterproject.app;

import br.com.eguadorodrigo.kafkastarterproject.config.KafkaProducerConfig;
import br.com.eguadorodrigo.kafkastarterproject.shared.TopicsConstants;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

public class NewOrderProducer {
    private static final KafkaProducerConfig kafkaProducerConfig = new KafkaProducerConfig(new KafkaProperties());

    public static void main(String[] args) {
        var newOrderMessage = "New Order via app Producer";
        var emailMessage = "Email via app Producer";

        var newOrderRecord = new ProducerRecord<>(TopicsConstants.ECOMMERCE_NEW_ORDER, newOrderMessage, newOrderMessage);
        var emailRecord = new ProducerRecord<>(TopicsConstants.ECOMMERCE_SEND_EMAIL, emailMessage, emailMessage);

        kafkaProducerConfig.kafkaTemplate().send(newOrderRecord);
        kafkaProducerConfig.kafkaTemplate().send(emailRecord);

    }
}
