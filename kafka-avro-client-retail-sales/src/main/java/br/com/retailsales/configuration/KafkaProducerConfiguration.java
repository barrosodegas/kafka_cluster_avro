package br.com.retailsales.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;

/**
 * Producer class of key string and value Avro record.
 * @author Andre Barroso
 *
 */
@Configuration
@EntityScan("br.com.retailsales.commons.model")
public class KafkaProducerConfiguration<k, v> {
	
	/**
	 * Kafka bootstrap servers
	 * The list of kafka servers in the cluster.
	 */
	@Value("${kafka.bootstrap.servers}")
	private String bootstrapServers;
	
	/**
	 * Defines how many replicas should receive the message besides the 
	 * leader so that the producer considers the delivered message.
	 */
	@Value("${kafka.acks}")
	private String acks;
	
	/**
	 * Key serializer.
	 */
	@Value("${kafka.key.serializer}")
	private String keySerializer;
	
	/**
	 * Value serializer.
	 */
	@Value("${kafka.value.serializer}")
	private String valueSerializer;
	
	/**
	 * URL Avro Schema Registry.
	 */
	@Value("${kafka.avro.schema.registry.url}")
	private String avroSchemaRegistryUrl;

	/**
	 * Method responsible to create the producer factory.
	 * @return Avro Producer factory.
	 */
	@Bean
	public ProducerFactory<k, v> producerFactory() {
		
		Map<String, Object> conf = new HashMap<>();
		conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
		conf.put(ProducerConfig.ACKS_CONFIG, this.acks);
		conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, this.keySerializer);
		conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, this.valueSerializer);
		conf.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, this.avroSchemaRegistryUrl);
	
		return new DefaultKafkaProducerFactory<>(conf);
	}
	
	/**
	 * Method responsible to create the producer kafka template.
	 * @return Producer Kafka template.
	 */
	@Bean
	public KafkaTemplate<k, v> kafkaTemplate() {
		return new KafkaTemplate<>(this.producerFactory());
	}

}
