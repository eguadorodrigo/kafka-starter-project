package br.com.eguadorodrigo.kafkastarterproject.config;

import br.com.eguadorodrigo.kafkastarterproject.shared.GlobalConstants;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    public ConsumerFactory<String, String> kafkaConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, GlobalConstants.KAFKA_URL_BASE);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GlobalConstants.KAFKA_CONSUME_GROUP_ID);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new StringDeserializer());
    }
}