package br.com.retailsales.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import br.com.retailsales.commons.RetailSalesStatus;
import br.com.retailsales.commons.avro.AvroStockSeparation;
import br.com.retailsales.commons.model.Invoice;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.commons.repository.InvoiceRepository;
import br.com.retailsales.commons.repository.OrderRepository;

/**
 * Callback class ProducerStockSeparationCallbackListener
 * Class accountable for running after sending data to the topic successfully or with error.
 * @author Andre Barroso
 */
@Component
public class ProducerStockSeparationCallbackListener extends ProducerCallbackListener<String, AvroStockSeparation, Invoice> {

	/**
	 * Order repository.
	 */
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * Invoice repository.
	 */
	@Autowired
	private InvoiceRepository invoiceRepository;

	/**
	 * Method executed when sending the message successfully.
	 * Updates the order and persists the invoice.
	 */
	@Override
	public void onSuccess(SendResult<String, AvroStockSeparation> result) {

		super.onSuccess(result);

		Order order = this.entityBase.getPayment().getOrder();
		order.setStatus(RetailSalesStatus.BILLED.name());
		this.orderRepository.save(order);
		
		this.entityBase.setStatus(RetailSalesStatus.BILLED.name());
		this.invoiceRepository.save(this.entityBase);
	}
	
}
