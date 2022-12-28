package br.com.eguadorodrigo.shared;

public interface KafkaConsumerBase {

    void processMessage(String kafkaMessage);

    void processObject(Object kafkaObject);
}
