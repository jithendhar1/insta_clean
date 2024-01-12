package com.weblabs.beans;

public class PaymentTransactionsBean {
	
	private String paymenttransactionsID;
	private String transactionID;
	private String customerID;
	private String paymentamount;
	private String paymentmethod;
	private String transactionstatus;	
	private String datetimestamp;
	private String cardholdername;
	private String maskedcardnumber;
	
	
	public String getPaymenttransactionsID() {
		return paymenttransactionsID;
	}
	public void setPaymenttransactionsID(String paymenttransactionsID) {
		this.paymenttransactionsID = paymenttransactionsID;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getPaymentamount() {
		return paymentamount;
	}
	public void setPaymentamount(String paymentamount) {
		this.paymentamount = paymentamount;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public String getTransactionstatus() {
		return transactionstatus;
	}
	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}
	public String getDatetimestamp() {
		return datetimestamp;
	}
	public void setDatetimestamp(String datetimestamp) {
		this.datetimestamp = datetimestamp;
	}
	public String getCardholdername() {
		return cardholdername;
	}
	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}
	public String getMaskedcardnumber() {
		return maskedcardnumber;
	}
	public void setMaskedcardnumber(String maskedcardnumber) {
		this.maskedcardnumber = maskedcardnumber;
	}
	
	
}
