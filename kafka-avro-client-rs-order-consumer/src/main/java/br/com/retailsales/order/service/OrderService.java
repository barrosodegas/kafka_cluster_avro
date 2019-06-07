package br.com.retailsales.order.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retailsales.commons.RetailSalesStatus;
import br.com.retailsales.commons.avro.AvroOrder;
import br.com.retailsales.commons.model.Customer;
import br.com.retailsales.commons.model.Order;
import br.com.retailsales.commons.model.OrderProduct;
import br.com.retailsales.commons.model.Product;
import br.com.retailsales.commons.repository.CustomerRepository;
import br.com.retailsales.commons.repository.OrderRepository;
import br.com.retailsales.commons.repository.ProductRepository;

/**
 * Service class OrderService
 * Class responsible for preparing the order to be persisted.
 * @author Andre Barroso
 */
@Service
public class OrderService {
	
	/**
	 * Customer repository.
	 */
	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Product repository.
	 */
	@Autowired
	private ProductRepository productRepository;

	/**
	 * Order repository.
	 */
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * Method responsible to prepare and persist the Order.
	 * @param avroOrder Avro Order
	 */
	public void persistOrder(AvroOrder avroOrder) {
		
		Customer customer = this.customerRepository.findByCode(avroOrder.getCustomerCode());

		final Order order = new Order();
		final List<OrderProduct> orderProducts = new ArrayList<>();
		
		avroOrder.getProductList().forEach( avroProduct -> {
			
			Product product = this.productRepository.findByCode(avroProduct.getProductCode());
			OrderProduct op = new OrderProduct();
			op.setProduct(product);
			op.setTotalAmount(avroProduct.getProductAmount());
			op.setTotalValue(BigDecimal.valueOf(avroProduct.getProductPrice() * avroProduct.getProductAmount()));
			op.setOrder(order);
			
			orderProducts.add(op);
		});
		
		DateTime date = DateTime.now();
		
		order.setCode("ord-" + date.getMillis());
		order.setCreateDate(new Timestamp(date.getMillis()));
		order.setCustomer(customer);
		order.setOrderProducts(orderProducts);
		order.setStatus(RetailSalesStatus.OPEN.name());
		
		this.orderRepository.save(order);
	}

}
