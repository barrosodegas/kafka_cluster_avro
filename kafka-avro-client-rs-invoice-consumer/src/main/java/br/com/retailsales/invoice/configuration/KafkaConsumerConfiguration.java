package br.com.retailsales.invoice.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import br.com.retailsales.commons.avro.AvroInvoice;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

/**
 * Configuration class KafkaConsumerConfiguration
 * Class responsible for defining instances of creating consumer factories.
 * @author Andre Barroso
 */
@EnableKafka
@Configuration
@EntityScan("br.com.retailsales.commons.model")
public class KafkaConsumerConfiguration {
	
	/**
	 * Kafka bootstrap servers
	 * The list of kafka servers in the cluster.
	 */
	@Value("${kafka.bootstrap.servers}")
	private String bootstrapServers;
	
	/**
	 * Consumer Group ID
	 */
	@Value("${kafka.comsumer.group.id}")
	private String consumerGroupId;
	
	/**
	 * Defines from which point the consumer should start reading the messages.
	 */
	@Value("${kafka.consumer.auto.offset.reset}")
	private String autoOffsetReset;
	
	/**
	 * Key deserializer.
	 */
	@Value("${kafka.key.deserializer}")
	private String keyDeserializer;
	
	/**
	 * Value deserializer.
	 */
	@Value("${kafka.value.deserializer}")
	private String valueDeserializer;
	
	/**
	 * URL Avro Schema Registry.
	 */
	@Value("${kafka.avro.schema.registry.url}")
	private String avroSchemaRegistryUrl;
	
	/**
	 * Defines that the object posted in the topic is a 
	 * specific Avro object and not a generic Avro object.
	 */
	@Value("${kafka.specific.avro.reader}")
	private String specificAvroReader;

	/**
	 * Method responsible to create the consumer factory.
	 * @return Avro Consumer factory.
	 */
	@Bean
	public ConsumerFactory<String, AvroInvoice> consumerFactory() {
		
		Map<String, Object> conf = new HashMap<>();
		
		conf.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
		conf.put(ConsumerConfig.GROUP_ID_CONFIG, this.consumerGroupId);
		conf.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, this.autoOffsetReset);
		conf.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, this.keyDeserializer);
		conf.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, this.valueDeserializer);
		conf.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, this.avroSchemaRegistryUrl);
		conf.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, this.specificAvroReader);
	
		return new DefaultKafkaConsumerFactory<>(conf);
	}
	
	/**
	 * Method responsible to create the Avro container listener factory.
	 * @return Avro Container Listener Factory.
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, AvroInvoice> kafkaListenerContainerFactory() {
		
		ConcurrentKafkaListenerContainerFactory<String, AvroInvoice> listener = new ConcurrentKafkaListenerContainerFactory<>();
		listener.setConsumerFactory(this.consumerFactory());
		
		return listener;
	}

}
