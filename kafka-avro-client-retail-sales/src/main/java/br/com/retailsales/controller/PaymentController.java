package br.com.retailsales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import br.com.retailsales.commons.model.Payment;
import br.com.retailsales.service.PaymentService;

/**
 * Controller class PaymentController
 * Class repsonsable by receiving calls from the browser to direct the requests.
 * @author Andre Barroso
 */
@Controller
public class PaymentController {

	/**
	 * Payment service.
	 */
	@Autowired
	private PaymentService paymentService;
	
	/**
	 * Method responsible to list payments.
	 * @param model Model view.
	 * @return HTML page name.
	 */
	@RequestMapping("viewPayments")
	public String viewPayments(Model model) {
		
		this.preparaAttributeList(model);
		
		return "payments";
	}
	
	/**
	 * Method responsible for approving billing and submitting data for the invoice topic.
	 * @param paymentId Payment ID.
	 * @param model Model view.
	 * @return Redirect view to list view.
	 */
	@RequestMapping("viewPayments/approve")
	public RedirectView approvePaymentToInvoice(@RequestParam(value = "paymentId") Long paymentId, Model model) {
		
		this.paymentService.approvePaymentToInvoice(paymentId);
		
		this.preparaAttributeList(model);
		
		return new RedirectView("/viewPayments");
	}

	/**
	 * Prepare attributes to view.
	 * @param model Model view.
	 */
	private void preparaAttributeList(Model model) {
		
		Iterable<Payment> payments = this.paymentService.findAll();
		model.addAttribute("payments", payments);
	}
	
}
