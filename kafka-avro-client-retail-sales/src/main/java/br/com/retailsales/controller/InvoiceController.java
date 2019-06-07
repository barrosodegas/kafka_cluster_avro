package br.com.retailsales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import br.com.retailsales.commons.model.Invoice;
import br.com.retailsales.service.InvoiceService;

/**
 * Controller class InvoiceController
 * Class repsonsable by receiving calls from the browser to direct the requests.
 * @author Andre Barroso
 */
@Controller
public class InvoiceController {

	/**
	 * Invoice service.
	 */
	@Autowired
	private InvoiceService invoiceService;
	
	/**
	 * Method responsible to list invoices.
	 * @param model Model view.
	 * @return HTML page name.
	 */
	@RequestMapping("viewInvoices")
	public String viewOrders(Model model) {
		
		this.preparaAttributeList(model);
		
		return "invoices";
	}
	
	/**
	 * Method responsible for approving billing and submitting data for the stock separation topic.
	 * @param invoiceId Invoice ID.
	 * @param model Model view.
	 * @return Redirect view to list view.
	 */
	@RequestMapping("viewInvoices/approve")
	public RedirectView approveInvoiceToStockeSeparation(@RequestParam(value = "invoiceId") Long invoiceId, Model model) {
		
		this.invoiceService.approveInvoiceToStockSeparation(invoiceId);
		
		this.preparaAttributeList(model);
		
		return new RedirectView("/viewInvoices");
	}

	/**
	 * Prepare attributes to view.
	 * @param model Model view.
	 */
	private void preparaAttributeList(Model model) {
		
		Iterable<Invoice> invoices = this.invoiceService.findAll();
		model.addAttribute("invoices", invoices);
	}
	
}
