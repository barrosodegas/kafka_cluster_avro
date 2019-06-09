package br.com.retailsales.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.avro.AvroInvoice;
import br.com.retailsales.commons.model.Payment;
import br.com.retailsales.commons.repository.PaymentRepository;
import br.com.retailsales.sender.TopicSender;

/**
 * Service class PaymentService
 * Class responsible for preparing the invoice to be persisted.
 * @author Andre Barroso
 */
@Service
public class PaymentService {

	/**
	 * Payment repository.
	 */
	@Autowired
	private PaymentRepository paymentRepository;
	
	/**
	 * Topic sender.
	 */
	@Autowired
	private TopicSender sender;
	
	/**
	 * Method responsible to find all payments.
	 * @return Payment list.
	 */
	public Iterable<Payment> findAll(){
		
		return this.paymentRepository.findAll();
	}
	
	/**
	 * Method responsible to find payment by ID.
	 * @param paymentId Payment ID.
	 * @return Payment.
	 */
	public Optional<Payment> findById(Long paymentId) {
		
		return this.paymentRepository.findById(paymentId);
	}
	
	/**
	 * Method responsible to save the Payment.
	 * @param payment Payment.
	 */
	public void save(Payment payment) {
		
		this.paymentRepository.save(payment);
	}
	
	/**
	 * Method responsible to approve invoice to invoice.
	 * @param paymentId Payment ID.
	 */
	public void approvePaymentToInvoice(Long paymentId) {
		Map<Optional<Payment>, AvroInvoice> invoiceMap = this.prepareInvoice(paymentId);
		
		if(invoiceMap != null) {
			invoiceMap.forEach((opPayment, invoice) -> {
				System.out.println("Sending invoice: " + invoice.getInvoiceCode() + " to the invoice topic.");
				
				this.sender.sendInvoice(invoice.getInvoiceCode(), invoice, opPayment.get());
			});
		}
	}

	/**
	 * Method responsible to prepare the Avro Invoice.
	 * @param paymentId Paymetn ID.
	 * @return Avro Invoice map.
	 */
	private Map<Optional<Payment>, AvroInvoice> prepareInvoice(Long paymentId) {
		
		Optional<Payment> payment = this.paymentRepository.findById(paymentId);
		
		if(payment.isPresent()) {
			
			DateTime date = DateTime.now();
			
			AvroInvoice avroInvoice = AvroInvoice.newBuilder()
										.setInvoiceCode("inv-" + date.getMillis())
										.setPaymentCode(payment.get().getCode())
										.setProcessingDate(date)
										.build();
			
			Map<Optional<Payment>, AvroInvoice> invoiceMap = new HashMap<>();
			invoiceMap.put(payment, avroInvoice);
			return invoiceMap;
		}
		return null;
	}
}
