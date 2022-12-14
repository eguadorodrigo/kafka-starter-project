package br.com.eguadorodrigo.kafkastarterproject.shared;

public interface KafkaConsumerBase {

    void processMessage(String kafkaMessage);

    void processObject(Object kafkaObject);
}
