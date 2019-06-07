package br.com.retailsales.commons;

/**
 * Enum class of Retail Sales Status.
 * These statuses are used for ordering, payment, and billing.
 * @author Andre Barroso
 */
public enum RetailSalesStatus {
	
	OPEN, 
	CANCELED,
	IN_PAYMENT,
	PAID_OUT,
	IN_BILLING,
	BILLED,
	IN_STOCK_SEPARATION, 
	RELEASED_FOR_DELIVERY, 
	OUT_FOR_DELIVERY, 
	DELIVERED
	
}
