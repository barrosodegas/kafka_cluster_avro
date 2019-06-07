package br.com.retailsales.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import br.com.retailsales.commons.RetailSalesStatus;
import br.com.retailsales.commons.avro.AvroInvoice;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.commons.model.Payment;
import br.com.retailsales.commons.repository.OrderRepository;
import br.com.retailsales.commons.repository.PaymentRepository;

/**
 * Callback class ProducerInvoiceCallbackListener
 * Class accountable for running after sending data to the topic successfully or with error.
 * @author Andre Barroso
 */
@Component
public class ProducerInvoiceCallbackListener extends ProducerCallbackListener<String, AvroInvoice, Payment> {

	/**
	 * Order repository.
	 */
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * Payment repository.
	 */
	@Autowired
	private PaymentRepository paymentRepository;

	/**
	 * Method executed when sending the message successfully.
	 * Updates the order and persists the payment.
	 */
	@Override
	public void onSuccess(SendResult<String, AvroInvoice> result) {

		super.onSuccess(result);
		
		Order order = this.entityBase.getOrder();
		order.setStatus(RetailSalesStatus.PAID_OUT.name());
		this.orderRepository.save(order);
		
		this.entityBase.setStatus(RetailSalesStatus.PAID_OUT.name());
		this.paymentRepository.save(this.entityBase);
	}
}
