package br.com.retailsales.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import br.com.retailsales.commons.RetailSalesStatus;
import br.com.retailsales.commons.avro.AvroPayment;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.commons.repository.OrderRepository;

/**
 * Callback class ProducerPaymentCallbackListener
 * Class accountable for running after sending data to the topic successfully or with error.
 * @author Andre Barroso
 */
@Component
public class ProducerPaymentCallbackListener extends ProducerCallbackListener<String, AvroPayment, Order> {

	/**
	 * Order repository.
	 */
	@Autowired
	private OrderRepository repository;

	/**
	 * Method executed when sending the message successfully.
	 * Updates the order and persists the order.
	 */
	@Override
	public void onSuccess(SendResult<String, AvroPayment> result) {

		super.onSuccess(result);

		this.entityBase.setStatus(RetailSalesStatus.IN_PAYMENT.name());

		this.repository.save(this.entityBase);
	}
}
