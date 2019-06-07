package br.com.retailsales.commons.utils;

import java.util.Map;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Class utils to execute the Avro producer.
 * @author Andre Barroso.
 *
 */
public class ProducerUtils {
	
	/**
	 * Method responsible for execute the Avro producer to partition defined.
	 * 
	 * @param <k> String Key data.
	 * @param <v> Avro value data.
	 * @param producer Avro producer.
	 * @param topic Topic name.
	 * @param partitionNumber Partition number
	 * @param mapRecordMap Record map to be sent.
	 */
	public static <k, v> void executeProducerByPartition(Producer<k, v> producer, String topic, 
			int partitionNumber, Map<k, v> mapRecordMap) {
		
		mapRecordMap.forEach((key, value) -> {

			// Send data with callback method class to validate asynchronous response.
			ProducerRecord<k, v> record = new ProducerRecord<>(topic, partitionNumber, key, value);
			producer.send(record, (metadata, exception) -> {
				
				if(exception == null) {
					System.out.println("Producing record with key: " + key 
							+ " to topic: " + metadata.topic() 
							+ ", partition: " + metadata.partition() 
							+ " and offset: " + metadata.offset());
				} else {
					System.out.println("Producing fail to record: " + key);
				}
			});
		});
	}
	
	/**
	 * Method responsible for execute the Avro producer to partition defined.
	 * 
	 * @param producer Avro producer.
	 * @param topic Topic name.
	 * @param partitionNumber Partition number
	 * @param <k> String Key data.
	 * @param <v> Avro value data.
	 */
	public static <k, v> void executeProducerByPartition(Producer<k, v> producer, String topic, 
			int partitionNumber, k key, v value) {
	
		// Send data with callback method class to validate asynchronous response.
		ProducerRecord<k, v> record = new ProducerRecord<>(topic, partitionNumber, key, value);
		producer.send(record, (metadata, exception) -> {
			
			if(exception == null) {
				System.out.println("Producing record with key: " + key 
						+ " to topic: " + metadata.topic() 
						+ ", partition: " + metadata.partition() 
						+ " and offset: " + metadata.offset());
			} else {
				System.out.println("Producing fail to record: " + key);
			}
		});
	}
	
	/**
	 * Method responsible for execute the Avro producer to topic defined.
	 * 
	 * @param <k> String Key data.
	 * @param <v> Avro value data.
	 * @param producer Avro producer.
	 * @param topic Topic name.
	 * @param partitionNumber Partition number
	 * @param mapRecordMap Record map to be sent.
	 */
	public static <k, v> void executeProducerByTopic(Producer<k, v> producer, String topic, Map<k, v> mapRecordMap) {
		
		mapRecordMap.forEach((key, value) -> {

			// Send data with callback method class to validate asynchronous response.
			ProducerRecord<k, v> record = new ProducerRecord<>(topic, key, value);
			producer.send(record, (metadata, exception) -> {
				
				if(exception == null) {
					System.out.println("Producing record with key: " + key 
							+ " to topic: " + metadata.topic() 
							+ ", partition: " + metadata.partition() 
							+ " and offset: " + metadata.offset());
				} else {
					System.out.println("Producing fail to record: " + key);
				}
			});
		});
	}
	
	/**
	 * Method responsible for execute the Avro producer to topic defined.
	 * 
	 * @param producer Avro producer.
	 * @param topic Topic name.
	 * @param partitionNumber Partition number
	 * @param <k> String Key data.
	 * @param <v> Avro value data.
	 */
	public static <k, v> void executeProducerByTopic(Producer<k, v> producer, String topic, k key, v value) {
	
		// Send data with callback method class to validate asynchronous response.
		ProducerRecord<k, v> record = new ProducerRecord<>(topic, key, value);
		producer.send(record, (metadata, exception) -> {
			
			if(exception == null) {
				System.out.println("Producing record with key: " + key 
						+ " to topic: " + metadata.topic() 
						+ ", partition: " + metadata.partition() 
						+ " and offset: " + metadata.offset());
			} else {
				System.out.println("Producing fail to record: " + key);
			}
		});
	}

}
