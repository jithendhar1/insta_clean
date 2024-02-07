package com.weblabs.beans;

import java.util.List;

public class AppointmentBean {
	private String appointmentID;
	private String customerID;
	private String VIN;
	private String appointmentdate;
	private String A11;
	private String A12;
	private String A13;
	private String A14;
	private String A15;
	private String A16;
	private String A17;
	private String A18;
	private String status;
	private String start_time;
	private String end_time;
	private String end_datetime;
	private String total_price;
	private String total_timetakes;
	private List<AppointmentServicesBean> ServiceDetailsList;
	
	
	
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
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	public String getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getA11() {
		return A11;
	}
	public void setA11(String a11) {
		A11 = a11;
	}
	public String getA12() {
		return A12;
	}
	public void setA12(String a12) {
		A12 = a12;
	}
	public String getA13() {
		return A13;
	}
	public void setA13(String a13) {
		A13 = a13;
	}
	public String getA14() {
		return A14;
	}
	public void setA14(String a14) {
		A14 = a14;
	}
	public String getA15() {
		return A15;
	}
	public void setA15(String a15) {
		A15 = a15;
	}
	public String getA16() {
		return A16;
	}
	public void setA16(String a16) {
		A16 = a16;
	}
	public String getA17() {
		return A17;
	}
	public void setA17(String a17) {
		A17 = a17;
	}
	public String getA18() {
		return A18;
	}
	public void setA18(String a18) {
		A18 = a18;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getEnd_datetime() {
		return end_datetime;
	}
	public void setEnd_datetime(String end_datetime) {
		this.end_datetime = end_datetime;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public String getTotal_timetakes() {
		return total_timetakes;
	}
	public void setTotal_timetakes(String total_timetakes) {
		this.total_timetakes = total_timetakes;
	}
	public List<AppointmentServicesBean> getServiceDetailsList() {
		return ServiceDetailsList;
	}
	public void setServiceDetailsList(List<AppointmentServicesBean> serviceDetailsList) {
		ServiceDetailsList = serviceDetailsList;
	}
	
}