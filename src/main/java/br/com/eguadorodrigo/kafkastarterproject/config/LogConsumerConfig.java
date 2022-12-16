package br.com.eguadorodrigo.kafkastarterproject.config;

import br.com.eguadorodrigo.kafkastarterproject.service.LogService;
import br.com.eguadorodrigo.kafkastarterproject.shared.GlobalConstants;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LogConsumerConfig {
    public ConsumerFactory<String, String> emailConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, GlobalConstants.KAFKA_URL_BASE);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GlobalConstants.LOG_GROUP_ID);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, LogService.class);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new StringDeserializer());
    }

}
