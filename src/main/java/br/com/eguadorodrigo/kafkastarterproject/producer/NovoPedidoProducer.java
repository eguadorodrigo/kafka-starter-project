package br.com.eguadorodrigo.kafkastarterproject.producer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import br.com.eguadorodrigo.kafkastarterproject.KafkaStarterProjectApplication;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.eguadorodrigo.kafkastarterproject.config.Topics;

@Component
public class NovoPedidoProducer {

	private static final Logger LOG = LoggerFactory.getLogger(NovoPedidoProducer.class);

    public static void execute() throws InterruptedException, ExecutionException{
        KafkaProducer<String, String> producer = new KafkaProducer<>(propriedades());

		String value = "Novo_Pedido,4,35.8,143.2";

		ProducerRecord<String, String> record = new ProducerRecord<String,String>(Topics.LOJA_NOVO_PEDIDO.getValue(), value, value);
		

		producer.send(record, (data, ex) -> {
			if (ex != null) {
				ex.printStackTrace();
				return;
			}
			LOG.info("Sucesso Enviado {}:::partition {}/ offset {}/ timestamp {}"
					,data.topic()
					,data.partition()
					,data.offset()
					,data.timestamp());
			
		}).get();
    }



	private static Properties propriedades() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
    
}