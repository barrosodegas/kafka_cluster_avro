package br.com.retailsales.controller;

import java.util.ArrayList;
import java.util.Collections;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import br.com.retailsales.commons.avro.AvroOrder;
import br.com.retailsales.commons.avro.AvroProduct;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.service.OrderService;

/**
 * Controller class OrderController
 * Class repsonsable by receiving calls from the browser to direct the requests.
 * @author Andre Barroso
 */
@Controller
public class OrderController {

	/**
	 * Order service.
	 */
	@Autowired
	private OrderService orderService;
	
	/**
	 * Load the home view.
	 * @return HTML page name
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	/**
	 * Method responsible to list orders.
	 * @param model Model view.
	 * @return HTML page name.
	 */
	@RequestMapping("viewOrders")
	public String viewOrders(Model model) {
		
		this.preparaAttributeList(model);
		
		return "orders";
	}
	
	/**
	 * Method responsible for approving billing and submitting data for the payment topic.
	 * @param orderId Order ID.
	 * @param model Model view.
	 * @return Redirect view to list view.
	 */
	@RequestMapping("viewOrders/approve")
	public RedirectView approveOrderToPayment(@RequestParam(value = "orderId") Long orderId, Model model) {
		
		this.orderService.approveOrderToPayment(orderId);
		
		this.preparaAttributeList(model);
		
		return new RedirectView("/viewOrders");
	}
	
	/**
	 * Method responsible for creating a mock of the application for registration.
	 * @param model Model view.
	 * @return HTML page name.
	 */
	@RequestMapping(path = "addOrder", method = RequestMethod.GET)
	public String addOrder(Model model) {
		
		DateTime date = DateTime.now();
		
		AvroOrder avroOrder = AvroOrder.newBuilder().setCustomerCode("cli-123")
								.setProductList(new ArrayList<>())
								.setOrderCode("ord-" + date.getMillis())
								.setProcessingDate(date)
								.build();
		
		model.addAttribute("avroOrder", avroOrder);
		
		return "order";
	}
	
	/**
	 * Method responsible to send order to topic.
	 * @param avroOrder Avro Order.
	 * @param model Model view.
	 * @return Redirect view.
	 */
	@RequestMapping(path = "addOrder", method = RequestMethod.POST)
	public RedirectView saveNewOrder(AvroOrder avroOrder, Model model) {
		
		
		AvroProduct avroProduct = AvroProduct.newBuilder().setProductCode("p-03")
									.setProductAmount(2)
									.setProductPrice(3.00)
									.build();
		
		avroOrder.setProductList(Collections.singletonList(avroProduct));
		
		this.orderService.addOrder(avroOrder);
		
		this.preparaAttributeList(model);
		
		return new RedirectView("/viewOrders");
	}

	/**
	 * Prepare attributes to view.
	 * @param model Model view.
	 */
	private void preparaAttributeList(Model model) {

		Iterable<Order> orders = this.orderService.findAll();
		model.addAttribute("orders", orders);

	}
	
}
