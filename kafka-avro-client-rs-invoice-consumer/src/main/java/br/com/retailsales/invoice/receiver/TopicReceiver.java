package br.com.retailsales.invoice.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.ClientConstants;
import br.com.retailsales.commons.avro.AvroInvoice;
import br.com.retailsales.invoice.service.InvoiceService;

/**
 * Service class TopicReceiver
 * Class responsible for listening to the topic and retrieving unread messages.
 * @author Andre Barroso
 */
@Service
public class TopicReceiver {
	
	/**
	 * Invoice service.
	 */
	@Autowired
	private InvoiceService invoiceService;
	
	/**
	 * Method responsible for receiving the Avro Invoice and persist in the base.
	 * @param avroInvoice Avro Invoice.
	 */
	@KafkaListener(topics = {ClientConstants.TOPIC_NAME_SALES_INVOICE})
	public void receiveAvroInvoice(AvroInvoice avroInvoice) {
		
		System.out.println("Invoice: " + avroInvoice.getInvoiceCode());
		
		this.invoiceService.persistInvoice(avroInvoice);
	}
	
}
