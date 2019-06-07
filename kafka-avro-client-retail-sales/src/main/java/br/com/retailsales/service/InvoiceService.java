package br.com.retailsales.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.avro.AvroStockSeparation;
import br.com.retailsales.commons.model.Invoice;
import br.com.retailsales.commons.repository.InvoiceRepository;
import br.com.retailsales.sender.TopicSender;

/**
 * Service class InvoiceService
 * Class responsible for preparing the invoice to be persisted.
 * @author Andre Barroso
 */
@Service
public class InvoiceService {

	/**
	 * Invoice repository.
	 */
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	/**
	 * Topic sender.
	 */
	@Autowired
	private TopicSender sender;
	
	/**
	 * Method responsible to find all invoices.
	 * @return Invoice list.
	 */
	public Iterable<Invoice> findAll(){
		
		return this.invoiceRepository.findAll();
	}
	
	/**
	 * Method responsible to find invoice by ID.
	 * @param invoiceId Invoice ID.
	 * @return Invoice.
	 */
	public Optional<Invoice> findById(Long invoiceId) {
		
		return this.invoiceRepository.findById(invoiceId);
	}
	
	/**
	 * Method responsible to save the Invoice.
	 * @param invoice Invoice.
	 */
	public void save(Invoice invoice) {
		
		this.invoiceRepository.save(invoice);
	}
	
	/**
	 * Method responsible to approve invoice to stock separation topic.
	 * @param invoiceId Invoice ID.
	 */
	public void approveInvoiceToStockSeparation(Long invoiceId) {
		Map<Invoice, AvroStockSeparation> stockSeparationMap = this.prepareStockSeparation(invoiceId);
		
		if(stockSeparationMap != null) {
			stockSeparationMap.forEach((invoice, stockSeparation) -> {
				this.sender.sendStockSeparation(stockSeparation.getStockSeparationCode(), stockSeparation, invoice);
			});
		}
	}

	/**
	 * Method responsible to prepare the Avro stock separation.
	 * @param invoiceId Invoice ID.
	 * @return Avro stock map.
	 */
	private Map<Invoice, AvroStockSeparation> prepareStockSeparation(Long invoiceId) {
		
		Optional<Invoice> opInvoice = this.invoiceRepository.findById(invoiceId);
		
		if(opInvoice.isPresent()) {
			
			DateTime date = DateTime.now();
			
			AvroStockSeparation avroStockSeparation = AvroStockSeparation.newBuilder()
														.setStockSeparationCode("sts-" + date.getMillis())
														.setInvoiceCode(opInvoice.get().getCode())
														.setOrderCode(opInvoice.get().getPayment().getOrder().getCode())
														.setProcessingDate(date)
														.build();
			
			Map<Invoice, AvroStockSeparation> stockSeparationMap = new HashMap<>();
			stockSeparationMap.put(opInvoice.get(), avroStockSeparation);
			return stockSeparationMap;
		}
		return null;
	}

}
