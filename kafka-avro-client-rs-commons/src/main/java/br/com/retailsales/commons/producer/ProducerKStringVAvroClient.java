package br.com.retailsales.commons.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import br.com.retailsales.commons.ClientConstants;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;

/**
 * Producer class of key string and value Avro record.
 * @author Andre Barroso
 */
public class ProducerKStringVAvroClient {
	
	/**
	 * Method responsible for create the producer with key String and Avro value serializers.
	 * 
	 * @param <v> Value of payload.
	 * @param brokers Borker list in string format separated by ",".
	 * @param clientIdProducer CLient ID producer.
	 * @param ackType Ack type - 0, 1 or all.
	 * @return producer Avro producer.
	 */
	public static <v> Producer<String, v> createProducer(String brokers, String clientIdProducer, String ackType) {
		
		Properties conf = new Properties();
		conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
		conf.put(ProducerConfig.CLIENT_ID_CONFIG, clientIdProducer);
		conf.put(ProducerConfig.ACKS_CONFIG, ackType);
		conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		conf.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, ClientConstants.SCHEMA_REGISTRY_URL);

		return new KafkaProducer<>(conf);
	}

}
