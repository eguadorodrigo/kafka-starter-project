package br.com.eguadorodrigo.kafkastarterproject;

import br.com.eguadorodrigo.kafkastarterproject.shared.GlobalConstants;
import br.com.eguadorodrigo.kafkastarterproject.shared.KafkaConsumerBase;
import br.com.eguadorodrigo.kafkastarterproject.shared.TopicsConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = TopicsConstants.ECOMMERCE_NEW_ORDER, groupId = GlobalConstants.FRAUD_GROUP_ID)
public class FraudDetectorService implements KafkaConsumerBase {
    private static final Logger LOG = LoggerFactory.getLogger(FraudDetectorService.class);

    @Override
    @KafkaHandler(isDefault = true)
    public void processMessage(String kafkaMessage) {
        if (kafkaMessage != null) {
            LOG.info("Content found! message by String:{}", kafkaMessage);
        }
    }

    @Override
    @KafkaHandler
    public void processObject(Object kafkaObject) {
        if (kafkaObject != null) {
            LOG.info("Content found! message by Object:{}", kafkaObject);
        }
    }
}
