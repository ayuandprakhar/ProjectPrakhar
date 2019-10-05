package wp.javaproject.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Deals {
	@Id
	private String deal_no;
	private String deal_description;
	private Date date;
	private String goingto_city;
	private double price;
	
	@OneToOne
	private Vehicle vehicle;
	
	@ManyToOne
	private Transporter transporter;

	public String getDeal_no() {
		return deal_no;
	}

	public void setDeal_no(String deal_no) {
		this.deal_no = deal_no;
	}

	public String getDeal_description() {
		return deal_description;
	}

	public void setDeal_description(String deal_description) {
		this.deal_description = deal_description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGoingto_city() {
		return goingto_city;
	}

	public void setGoingto_city(String goingto_city) {
		this.goingto_city = goingto_city;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Deals(String deal_no, String deal_description, Date date, String goingto_city, double price, Vehicle vehicle,
			Transporter transporter) {
		super();
		this.deal_no = deal_no;
		this.deal_description = deal_description;
		this.date = date;
		this.goingto_city = goingto_city;
		this.price = price;
		this.vehicle = vehicle;
		this.transporter = transporter;
	}

	public Deals() {
		super();
	}
	
	
}
