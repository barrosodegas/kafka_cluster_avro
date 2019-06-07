package br.com.retailsales.callback;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Callback class ProducerCallbackListener
 * Abstract class accountable for running after sending data to the topic successfully or with error.
 * @author Andre Barroso
 *
 * @param <K> Key
 * @param <V> Avro Value
 * @param <E> Entity base
 */
public abstract class ProducerCallbackListener<K, V, E> implements ListenableFutureCallback<SendResult<K, V>> {

	/**
	 * Entity base to be persisted.
	 */
	protected E entityBase;
	
	/**
	 * Sets the entity.
	 * @param entityBase Entity base.
	 */
	public void setupEntityBase(E entityBase) {
		this.entityBase = entityBase;
	}

	/**
	 * Method executed when sending the message successfully.
	 */
	@Override
	public void onSuccess(SendResult<K, V> result) {
		
		System.out.println("Request sent to topic: " + result.getRecordMetadata().topic());
	}

	/**
	 *Method executed when message sending fails.
	 */
	@Override
	public void onFailure(Throwable ex) {
		
		System.out.println("Failed to submit request!");
		ex.printStackTrace();
	}

}
