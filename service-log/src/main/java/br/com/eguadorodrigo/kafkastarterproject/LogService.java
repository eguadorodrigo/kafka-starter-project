package br.com.eguadorodrigo.kafkastarterproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import br.com.eguadorodrigo.kafkastarterproject.shared.GlobalConstants;
import br.com.eguadorodrigo.kafkastarterproject.shared.KafkaConsumerBase;

@Component
@KafkaListener(topicPattern = "ECOMMERCE.*", groupId = GlobalConstants.LOG_GROUP_ID)
public class LogService implements KafkaConsumerBase {

    private static final Logger LOG = LoggerFactory.getLogger(LogService.class);

    @Override
    @KafkaHandler(isDefault = true)
    public void processMessage(String kafkaMessage) {
        LOG.info("message by String:{}", kafkaMessage);
    }

    @Override
    @KafkaHandler
    public void processObject(Object kafkaObject) {
        LOG.info("message by Object:{}", kafkaObject);
    }

}
