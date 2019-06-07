package br.com.retailsales.commons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Entity class Payment.
 * @author Andre Barroso.
 */
@Entity(name = "payment")
@DynamicInsert
@DynamicUpdate
public class Payment {

	/**
	 * Payment ID.
	 */
	@Id
	@Column(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	
	/**
	 * Payment code.
	 */
	@Column(nullable = false, unique = true)
	private String code;
	
	/**
	 * Order to which the payment is linked.
	 */
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumns({@JoinColumn( name = "order_id", referencedColumnName = "order_id")})
	private Order order;
	
	/**
	 * Total quantity of products in the order.
	 */
	@Column(name = "total_amount", nullable = false)
	private Integer totalAmount;
	
	/**
	 * Total value of the products of the order.
	 */
	@Column(name = "total_value", nullable = false)
	private BigDecimal totalValue;
	
	/**
	 * Payment creation date.
	 */
	@Column(name = "create_date", nullable = false)
	private Timestamp createDate;
	
	/**
	 * Payment update date.
	 */
	@Column(name = "update_date")
	private Timestamp updateDate;
	
	/**
	 * Payment status.
	 */
	@Column(nullable = false)
	private String status;

	/**
	 * @return the paymentId
	 */
	public Long getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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
	
}
