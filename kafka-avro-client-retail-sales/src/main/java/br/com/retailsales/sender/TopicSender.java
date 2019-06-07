package br.com.retailsales.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.retailsales.callback.ProducerInvoiceCallbackListener;
import br.com.retailsales.callback.ProducerOrderCallbackListener;
import br.com.retailsales.callback.ProducerPaymentCallbackListener;
import br.com.retailsales.callback.ProducerStockSeparationCallbackListener;
import br.com.retailsales.commons.avro.AvroInvoice;
import br.com.retailsales.commons.avro.AvroOrder;
import br.com.retailsales.commons.avro.AvroPayment;
import br.com.retailsales.commons.avro.AvroStockSeparation;
import br.com.retailsales.commons.model.Invoice;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.commons.model.Payment;

/**
 * Sender class TopicSender
 * Class responsible for sending messages to topics.
 * @author Andre Barroso
 */
@Component
public class TopicSender {
	
	/**
	 * Order template.
	 */
	@Autowired
	private KafkaTemplate<String, AvroOrder> kafkaOrderTemplate;

	/**
	 * Payment template.
	 */
	@Autowired
	private KafkaTemplate<String, AvroPayment> kafkaPaymentTemplate;

	/**
	 * Invoice template.
	 */
	@Autowired
	private KafkaTemplate<String, AvroInvoice> kafkaInvoiceTemplate;

	/**
	 * Stock separation template.
	 */
	@Autowired
	private KafkaTemplate<String, AvroStockSeparation> kafkaStockSeparationTemplate;
	
	/**
	 * Order callback.
	 */
	@Autowired
	private ProducerOrderCallbackListener orderCallback;
	
	/**
	 * Payment callback.
	 */
	@Autowired
	private ProducerPaymentCallbackListener paymentCallback;
	
	/**
	 * Invoice callback.
	 */
	@Autowired
	private ProducerInvoiceCallbackListener invoiceCallback;
	
	/**
	 * Stock separation callback.
	 */
	@Autowired
	private ProducerStockSeparationCallbackListener stockSeparationCallback;
	
	/**
	 * Propertie Order topic name
	 */
	@Value("${kafka.topic.order}")
	private String orderTopic;
	
	/**
	 * Propertie Payment topic name
	 */
	@Value("${kafka.topic.payment}")
	private String paymentTopic;
	
	/**
	 * Propertie Invoice topic name
	 */
	@Value("${kafka.topic.invoice}")
	private String invoiceTopic;
	
	/**
	 * Propertie Stock separation topic name
	 */
	@Value("${kafka.topic.stock.separation}")
	private String stockSeparationTopic;

	/**
	 * Method responsible for sending the message to the orders queue and calling the callback.
	 * @param key Key of message.
	 * @param value The Avro message.
	 */
	public void sendOrder(String key, AvroOrder value) {
		
		this.kafkaOrderTemplate.send(this.orderTopic, key, value)
			.addCallback(this.orderCallback);
	}

	/**
	 * Method responsible for sending the message to the payments queue and calling the callback.
	 * @param key Key of message.
	 * @param value The Avro message.
	 */
	public void sendPayment(String key, AvroPayment value, Order order) {
		
		this.paymentCallback.setupEntityBase(order);
		
		this.kafkaPaymentTemplate.send(this.paymentTopic, key, value)
			.addCallback(this.paymentCallback);
	}

	/**
	 * Method responsible for sending the message to the invoices queue and calling the callback.
	 * @param key Key of message.
	 * @param value The Avro message.
	 */
	public void sendInvoice(String key, AvroInvoice value, Payment payment) {
		
		this.invoiceCallback.setupEntityBase(payment);
		
		this.kafkaInvoiceTemplate.send(this.invoiceTopic, key, value)
			.addCallback(this.invoiceCallback);
	}

	/**
	 * Method responsible for sending the message to the stock separation queue and calling the callback.
	 * @param key Key of message.
	 * @param value The Avro message.
	 */
	public void sendStockSeparation(String key, AvroStockSeparation value, Invoice invoice) {
		
		this.stockSeparationCallback.setupEntityBase(invoice);
		
		this.kafkaStockSeparationTemplate.send(this.stockSeparationTopic, key, value)
			.addCallback(this.stockSeparationCallback);
	}
	
}
