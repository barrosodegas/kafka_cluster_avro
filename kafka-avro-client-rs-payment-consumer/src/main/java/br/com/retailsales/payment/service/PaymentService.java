package br.com.retailsales.payment.service;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.RetailSalesStatus;
import br.com.retailsales.commons.avro.AvroPayment;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.commons.model.Payment;
import br.com.retailsales.commons.repository.OrderRepository;
import br.com.retailsales.commons.repository.PaymentRepository;

/**
 * Service class PaymentService
 * Class responsible for preparing the invoice to be persisted.
 * @author Andre Barroso
 */
@Service
public class PaymentService {

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
	 * Method responsible to prepare and persist the Payment.
	 * @param avroPayment Avro Payment
	 */
	public void persistPayment(AvroPayment avroPayment) {
		
		Order order = this.orderRepository.findByCode(avroPayment.getOrderCode());
		
		final Payment payment = new Payment();
		payment.setCode(avroPayment.getPaymentCode());
		payment.setOrder(order);
		payment.setCreateDate(new Timestamp(avroPayment.getProcessingDate().getMillis()));
		payment.setTotalAmount(0);
		payment.setTotalValue(BigDecimal.ZERO);
		payment.setStatus(RetailSalesStatus.IN_PAYMENT.name());
		
		order.getOrderProducts().forEach( o -> {
			payment.setTotalAmount(payment.getTotalAmount() + o.getTotalAmount());
			payment.setTotalValue(payment.getTotalValue().add(o.getTotalValue()));
		});
		
		this.paymentRepository.save(payment);
	}

}
