package br.com.retailsales.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.avro.AvroOrder;
import br.com.retailsales.commons.avro.AvroPayment;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.commons.repository.OrderRepository;
import br.com.retailsales.sender.TopicSender;

/**
 * Service class OrderService
 * Class responsible for preparing the invoice to be persisted.
 * @author Andre Barroso
 */
@Service
public class OrderService {

	/**
	 * Order repository.
	 */
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * Topic sender.
	 */
	@Autowired
	private TopicSender sender;
	
	/**
	 * Method responsible to find all orders.
	 * @return Order list.
	 */
	public Iterable<Order> findAll(){
		
		return this.orderRepository.findAll();
	}
	
	/**
	 * Method responsible to find order by ID.
	 * @param orderId Order ID.
	 * @return Order.
	 */
	public Optional<Order> findById(Long orderId) {
		
		return this.orderRepository.findById(orderId);
	}
	
	/**
	 * Method responsible to save the Order.
	 * @param order Order.
	 */
	public void save(Order order) {
		
		this.orderRepository.save(order);
	}

	/**
	 * Method responsile to add to topic. 
	 * @param avroOrder Avro Order.
	 */
	public void addOrder(AvroOrder avroOrder) {
		
		System.out.println("Sending order: " + avroOrder.getOrderCode() + " to the ordering topic.");
		
		this.sender.sendOrder(avroOrder.getOrderCode(), avroOrder);
	}
	
	/**
	 * Method responsible to approve order to payment topic.
	 * @param orderId Order ID.
	 */
	public void approveOrderToPayment(Long orderId) {
		Map<Optional<Order>, AvroPayment> paymentMap = this.preparePayment(orderId);
		
		if(paymentMap != null) {
			paymentMap.forEach((opOrder, payment) -> {
				
				System.out.println("Order sent to payment topic");
				
				this.sender.sendPayment(payment.getPaymentCode(), payment, opOrder.get());
			});
		}
	}
	
	/**
	 * Method responsible to prepare the Avro Payment.
	 * @param orderId Order ID.
	 * @return Avro Payment map.
	 */
	private Map<Optional<Order>, AvroPayment> preparePayment(Long orderId) {
		
		Optional<Order> order = this.orderRepository.findById(orderId);
		if(order.isPresent()) {
			DateTime date = DateTime.now();

			final AvroPayment payment = AvroPayment.newBuilder()
											.setOrderCode(order.get().getCode())
											.setPaymentCode("pay-" + date.getMillis())
											.setProcessingDate(date)
											.setTotalAmount(0)
											.setTotalValue(0.0)
											.build();
			
			order.get().getOrderProducts().forEach( op -> {
				payment.setTotalAmount(payment.getTotalAmount() + op.getTotalAmount());
				payment.setTotalValue(payment.getTotalValue() + op.getTotalValue().doubleValue());
			});
			
			Map<Optional<Order>, AvroPayment> result = new HashMap<>();
			result.put(order, payment);
			return result;
		}
		return null;
	}

}
