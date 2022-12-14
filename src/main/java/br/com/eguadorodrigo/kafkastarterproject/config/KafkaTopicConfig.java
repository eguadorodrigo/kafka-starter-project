package br.com.eguadorodrigo.kafkastarterproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaTopicConfig.class);
    private static final String LOGGER_TEXT = "Criando tópico {}";

    @Bean
    public NewTopic quickStart() {
        LOG.info(LOGGER_TEXT, Topics.QUICKSTART.getValue());
        return TopicBuilder.name(Topics.QUICKSTART.getValue()).build();
    }

    @Bean
    public NewTopic newOrder() {
        LOG.info(LOGGER_TEXT, Topics.ECOMMERCE_NEW_ORDER.getValue());
        return TopicBuilder.name(Topics.ECOMMERCE_NEW_ORDER.getValue()).build();
    }

    @Bean
    public NewTopic novoPedido() {
        LOG.info(LOGGER_TEXT, Topics.LOJA_NOVO_PEDIDO.getValue());
        return TopicBuilder.name(Topics.LOJA_NOVO_PEDIDO.getValue()).build();
    }

    @Bean
    public NewTopic sendEmail() {
        LOG.info(LOGGER_TEXT, Topics.ECOMMERCE_SEND_EMAIL.getValue());
        return TopicBuilder.name(Topics.ECOMMERCE_SEND_EMAIL.getValue()).build();
    }

}
