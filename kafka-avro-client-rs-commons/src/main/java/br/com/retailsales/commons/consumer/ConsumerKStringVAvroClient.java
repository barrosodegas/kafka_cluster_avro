package br.com.retailsales.commons.consumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import br.com.retailsales.commons.ClientConstants;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

/**
 * Consumer class of key string and value Avro record.
 * @author Andre Barroso
 *
 */
public class ConsumerKStringVAvroClient {
	
	/**
	 * Method responsible for create the Avro consumer to the partition defined.
	 * 
	 * @param <v> Value Avro to be sent.
	 * @param brokers Borker list in string format separated by ",".
	 * @param groupId Group ID of consumer.
	 * @param consumerId Client ID of consumer.
	 * @param maxPollRecords Max poll records gets of topic to be processed.
	 * @param autoOffsetReset Auto offset reset type.
	 * @param topic Topic name.
	 * @param partitionNumber Partition number.
	 * @return consumer Avro consumer.
	 */
	public static <v> Consumer<String, v> createConsumerByPartition(String brokers, String groupId, String consumerId,
			int maxPollRecords, String autoOffsetReset, String topic, int partitionNumber) {
		
		Properties conf = new Properties();
		conf.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
		conf.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		conf.put(ConsumerConfig.CLIENT_ID_CONFIG, consumerId);
		conf.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
		conf.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
		conf.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, ClientConstants.ENABLE_AUTO_COMMIT);
		conf.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		conf.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		conf.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, ClientConstants.SCHEMA_REGISTRY_URL);
		conf.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, ClientConstants.SPECIFIC_AVRO_READER);
		
		Consumer<String, v> consumer = new KafkaConsumer<>(conf);
		
		TopicPartition partition = new TopicPartition(topic, partitionNumber);
		consumer.assign(Collections.singletonList(partition));
		
		return consumer;
	}
	
	/**
	 * Method responsible for create the Avro consumer to the topics defined.
	 * 
	 * @param <v> Value Avro to be sent.
	 * @param brokers Borker list in string format separated by ",".
	 * @param groupId Group ID of consumer.
	 * @param consumerId Client ID of consumer.
	 * @param maxPollRecords Max poll records gets of topic to be processed.
	 * @param autoOffsetReset Auto offset reset type.
	 * @param topics Topic list name.
	 * @param partitionNumber Partition number.
	 * @return consumer Avro consumer.
	 */
	public static <v> Consumer<String, v> createConsumerByTopics(String brokers, String groupId, String consumerId,
			int maxPollRecords, String autoOffsetReset, String... topics) {
		
		Properties conf = new Properties();
		conf.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
		conf.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		conf.put(ConsumerConfig.CLIENT_ID_CONFIG, consumerId);
		conf.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
		conf.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
		conf.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, ClientConstants.ENABLE_AUTO_COMMIT);
		conf.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		conf.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		conf.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, ClientConstants.SCHEMA_REGISTRY_URL);
		conf.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, ClientConstants.SPECIFIC_AVRO_READER);
		
		Consumer<String, v> consumer = new KafkaConsumer<>(conf);
		consumer.subscribe(Arrays.asList(topics));
		
		return consumer;
	}
}
