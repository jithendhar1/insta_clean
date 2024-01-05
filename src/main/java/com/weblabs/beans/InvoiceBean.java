package com.weblabs.beans;

public class InvoiceBean {

	private String invoiceID;
	private String appointmentID;
	private String customerID;
	private String invoicedate;
	private String duedate;
	private String totalamt;
	private String otherinformation;
	private String tax;
	private String discount;
	private String taxamount;
	
	
	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public String getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(String totalamt) {
		this.totalamt = totalamt;
	}
	public String getOtherinformation() {
		return otherinformation;
	}
	public void setOtherinformation(String otherinformation) {
		this.otherinformation = otherinformation;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getTaxamount() {
		return taxamount;
	}
	public void setTaxamount(String taxamount) {
		this.taxamount = taxamount;
	}
		
	
	
}
