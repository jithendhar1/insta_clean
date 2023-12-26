package com.weblabs.beans;

public class RefundBean {


	private String refundID;
	private String paymentID;
	private String customerID;
	private String refunddate;
	private String refundamount;
	private String reason;
	
	public String getRefundID() {
		return refundID;
	}
	public void setRefundID(String refundID) {
		this.refundID = refundID;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getRefunddate() {
		return refunddate;
	}
	public void setRefunddate(String refunddate) {
		this.refunddate = refunddate;
	}
	public String getRefundamount() {
		return refundamount;
	}
	public void setRefundamount(String refundamount) {
		this.refundamount = refundamount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
