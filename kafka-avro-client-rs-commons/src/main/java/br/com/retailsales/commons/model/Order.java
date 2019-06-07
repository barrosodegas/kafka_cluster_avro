package br.com.retailsales.commons.model;

import java.sql.Timestamp;
import java.util.List;

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
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Entity class Order.
 * @author Andre Barroso.
 */
@Entity(name = "order_sales")
@DynamicInsert
@DynamicUpdate
public class Order {

	/**
	 * Order ID.
	 */
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	/**
	 * Order code.
	 */
	@Column(nullable = false, unique = true)
	private String code;
	
	/**
	 * The customer who placed the order.
	 */
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumns({@JoinColumn( name = "customer_id", referencedColumnName = "customer_id")})
	private Customer customer;
	
	/**
	 * The product list of the order.
	 */
	@OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<OrderProduct> orderProducts;
	
	/**
	 * Order status.
	 */
	@Column(nullable = false)
	private String status;
	
	/**
	 * Order creation date.
	 */
	@Column(name = "create_date", nullable = false)
	private Timestamp createDate;
	
	/**
	 * Order update date.
	 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the orderProducts
	 */
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	/**
	 * @param orderProducts the orderProducts to set
	 */
	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createDate
	 */
	public Timestamp getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}
