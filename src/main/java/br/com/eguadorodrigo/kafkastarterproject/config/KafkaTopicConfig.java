package br.com.eguadorodrigo.kafkastarterproject.config;

import br.com.eguadorodrigo.kafkastarterproject.shared.TopicsConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private static final int MINIMUM_PARTITION = 2;

    private static final Logger LOG = LoggerFactory.getLogger(KafkaTopicConfig.class);
    private static final String LOGGER_TEXT = "Criando tópico {}";

    @Bean
    public NewTopic quickStart() {
        LOG.info(LOGGER_TEXT, TopicsConstants.QUICKSTART);
        return TopicBuilder
                .name(TopicsConstants.QUICKSTART)
                .build();
    }

    @Bean
    public NewTopic newOrder() {
        LOG.info(LOGGER_TEXT, TopicsConstants.ECOMMERCE_NEW_ORDER);
        return TopicBuilder
                .name(TopicsConstants.ECOMMERCE_NEW_ORDER)
                .partitions(MINIMUM_PARTITION)
                .build();
    }

    @Bean
    public NewTopic novoPedido() {
        LOG.info(LOGGER_TEXT, TopicsConstants.LOJA_NOVO_PEDIDO);
        return TopicBuilder
                .name(TopicsConstants.LOJA_NOVO_PEDIDO)
                .build();
    }

    @Bean
    public NewTopic sendEmail() {
        LOG.info(LOGGER_TEXT, TopicsConstants.ECOMMERCE_SEND_EMAIL);
        return TopicBuilder
                .name(TopicsConstants.ECOMMERCE_SEND_EMAIL)
                .partitions(MINIMUM_PARTITION)
                .build();
    }

}