package br.com.retailsales.payment.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.ClientConstants;
import br.com.retailsales.commons.avro.AvroPayment;
import br.com.retailsales.payment.service.PaymentService;

/**
 * Service class TopicReceiver
 * Class responsible for listening to the topic and retrieving unread messages.
 * @author Andre Barroso
 */
@Service
public class TopicReceiver {
	
	/**
	 * Payment service.
	 */
	@Autowired
	PaymentService paymentService;
	
	/**
	 * Method responsible for receiving the Avro Payment and persist in the base.
	 * @param avroPayment Avro Payment.
	 */
	@KafkaListener(topics = {ClientConstants.TOPIC_NAME_SALES_PAYMENT})
	public void receiveAvroPayment(AvroPayment avroPayment) {
		
		System.out.println("Payment: " + avroPayment.getPaymentCode());
		
		this.paymentService.persistPayment(avroPayment);
	}
	
}
