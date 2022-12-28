package br.com.eguadorodrigo;

import br.com.eguadorodrigo.config.KafkaProducerConfig;
import br.com.eguadorodrigo.shared.TopicsConstants;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

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
