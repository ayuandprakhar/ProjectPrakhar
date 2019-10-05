package wp.javaproject.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
@Id
private String number;
private String model;
private String type;
private Blob registration;

@OneToOne(mappedBy = "vehicle")
private Deals deals;

@ManyToOne
private Transporter transporter;

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Blob getRegistration() {
	return registration;
}

public void setRegistration(Blob registration) {
	this.registration = registration;
}

public Deals getDeals() {
	return deals;
}

public void setDeals(Deals deals) {
	this.deals = deals;
}

public Transporter getTransporter() {
	return transporter;
}

public void setTransporter(Transporter transporter) {
	this.transporter = transporter;
}

public Vehicle(String number, String model, String type, Blob registration, Deals deals, Transporter transporter) {
	super();
	this.number = number;
	this.model = model;
	this.type = type;
	this.registration = registration;
	this.deals = deals;
	this.transporter = transporter;
}

public Vehicle() {
	super();
}

}
