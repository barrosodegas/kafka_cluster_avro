package br.com.retailsales.commons.model;

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
 * Entity class Invoice.
 * @author Andre Barroso.
 */
@Entity(name = "invoice")
@DynamicInsert
@DynamicUpdate
public class Invoice {

	/**
	 * Invoice ID.
	 */
	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long invoiceId;
	
	/**
	 * Invoice code.
	 */
	@Column(nullable = false, unique = true)
	private String code;

	/**
	 * Payment to which the invoice is linked.
	 */
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumns({@JoinColumn( name = "payment_id", referencedColumnName = "payment_id")})
	private Payment payment;
	
	/**
	 * Invoice creation date.
	 */
	@Column(name = "create_date", nullable = false)
	private Timestamp createDate;
	
	/**
	 * Invoice update date.
	 */
	@Column(name = "update_date")
	private Timestamp updateDate;
	
	/**
	 * Invoice status.
	 */
	@Column(nullable = false)
	private String status;

	/**
	 * @return the invoiceId
	 */
	public Long getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
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
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
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
