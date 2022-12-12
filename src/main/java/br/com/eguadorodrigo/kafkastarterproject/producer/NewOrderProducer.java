package br.com.eguadorodrigo.kafkastarterproject.producer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

import br.com.eguadorodrigo.kafkastarterproject.Topics;

@Component
public class NewOrderProducer {

    public static void execute() throws InterruptedException, ExecutionException{
        KafkaProducer<String, String> producer = new KafkaProducer<>(propriedades());

		String value = "New_Order,10, 500, 5000";
		String email = "Welcome! we are processing your order";

		ProducerRecord<String, String> record = new ProducerRecord<String,String>(Topics.ECOMMERCE_NEW_ORDER.getValue(), value, value);
		ProducerRecord<String, String> emailRecord = new ProducerRecord<String,String>(Topics.ECOMMERCE_NEW_ORDER.getValue(), email, email);

		Callback callback =  (data, ex) -> {
			if (ex != null) {
				ex.printStackTrace();
				return;
			}
			System.out.println("Sucesso Enviado "
					+ data.topic()
					+ ":::partition "
					+ data.partition()
					+ "/ offset "
					+ data.offset()
					+ "/ timestamp "
					+ data.timestamp());

		};

		producer.send(record,callback).get();
		producer.send(emailRecord, callback).get();
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
