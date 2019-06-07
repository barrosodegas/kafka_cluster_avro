package br.com.retailsales.order.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.ClientConstants;
import br.com.retailsales.commons.avro.AvroOrder;
import br.com.retailsales.order.service.OrderService;

/**
 * Service class TopicReceiver
 * Class responsible for listening to the topic and retrieving unread messages.
 * @author Andre Barroso
 */
@Service
public class TopicReceiver {
	
	/**
	 * Order service.
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * Method responsible for receiving the Avro Order and persist in the base.
	 * @param avroOrder Avro Order.
	 */
	@KafkaListener(topics = {ClientConstants.TOPIC_NAME_SALES_ORDER})
	public void receiveAvroOrder(AvroOrder avroOrder) {
		
		System.out.println("Order: " + avroOrder.getOrderCode());
		
		this.orderService.persistOrder(avroOrder);
	}
	
}
