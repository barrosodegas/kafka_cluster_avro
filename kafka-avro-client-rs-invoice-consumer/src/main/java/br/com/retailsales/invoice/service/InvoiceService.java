package br.com.retailsales.invoice.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.RetailSalesStatus;
import br.com.retailsales.commons.avro.AvroInvoice;
import br.com.retailsales.commons.model.Invoice;
import br.com.retailsales.commons.model.Payment;
import br.com.retailsales.commons.repository.InvoiceRepository;
import br.com.retailsales.commons.repository.PaymentRepository;

/**
 * Service class InvoiceService
 * Class responsible for preparing the invoice to be persisted.
 * @author Andre Barroso
 */
@Service
public class InvoiceService {

	/**
	 * Payment repository.
	 */
	@Autowired
	private PaymentRepository paymentRepository;
	
	/**
	 * Invoice repository.
	 */
	@Autowired
	private InvoiceRepository invoiceRepository;

	/**
	 * Method responsible to prepare and persist the Invoice.
	 * @param avroInvoice Avro Invoice
	 */
	public void persistInvoice(AvroInvoice avroInvoice) {
		
		Payment payment = this.paymentRepository.findByCode(avroInvoice.getPaymentCode());
		
		Invoice invoice = new Invoice();
		invoice.setCode(avroInvoice.getInvoiceCode());
		invoice.setPayment(payment);
		invoice.setCreateDate(new Timestamp(avroInvoice.getProcessingDate().getMillis()));
		invoice.setStatus(RetailSalesStatus.IN_BILLING.name());
		
		this.invoiceRepository.save(invoice);
		
		System.out.println("Consumed and persisted the invoice: " + avroInvoice.getInvoiceCode());
	}

}
