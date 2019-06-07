package br.com.retailsales.commons.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Entity class OrderProduct.
 * @author Andre Barroso.
 */
@Entity( name = "order_sales_product")
@DynamicInsert
@DynamicUpdate
public class OrderProduct {

	/**
	 * Order product ID.
	 */
	@Id
	@Column(name = "order_product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderProductId;

	/**
	 * The order to which the product is linked.
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	private Order order;
	
	/**
	 * Product of order.
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumns({@JoinColumn( name = "product_id", referencedColumnName = "product_id")})
	private Product product;
	
	/**
	 * Total quantity of a product for the order.
	 */
	@Column(name = "total_amount", nullable = false)
	private Integer totalAmount;
	
	/**
	 * Total value of a product for the order based on the quantity requested.
	 */
	@Column(name = "total_value", nullable = false)
	private BigDecimal totalValue;

	/**
	 * @return the orderProductId
	 */
	public Long getOrderProductId() {
		return orderProductId;
	}

	/**
	 * @param orderProductId the orderProductId to set
	 */
	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the totalAmount
	 */
	public Integer getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the totalValue
	 */
	public BigDecimal getTotalValue() {
		return totalValue;
	}

	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}
	
}
