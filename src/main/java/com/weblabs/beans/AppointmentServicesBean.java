package com.weblabs.beans;

import java.util.List;

public class AppointmentServicesBean {
	
	private String ID;
	private String serviceID;
	private String servicename;
	private String price;
	private String timetakes;
	private String appointmentID;
	private String workerID;
	private AppointmentBean appointment;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTimetakes() {
		return timetakes;
	}
	public void setTimetakes(String timetakes) {
		this.timetakes = timetakes;
	}
	public String getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	public String getWorkerID() {
		return workerID;
	}
	public void setWorkerID(String workerID) {
		this.workerID = workerID;
	}
	public AppointmentBean getAppointment() {
		return appointment;
	}
	public void setAppointment(AppointmentBean appointment) {
		this.appointment = appointment;
	}

	
	
	
}
