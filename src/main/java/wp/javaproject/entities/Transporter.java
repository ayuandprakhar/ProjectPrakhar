package wp.javaproject.entities;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transporter {
	@Id
	private String email;
	private String transporter_id;
	private String transporter_firm_name;
	private String password;
	private String transporter_address;
	private String mobile;
	private String transporter_pan_no;
	private String transporter_gst_no;
	private Blob idproof;
	private boolean verify;
	
	public boolean isVerify() {
		return verify;
	}
	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	@OneToMany(mappedBy="transporter")
	private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	@OneToMany(mappedBy="transporter")
	private List<Deals> deals= new ArrayList<Deals>();
	
	@OneToMany(mappedBy = "transporter")
	private List<Query> query= new ArrayList<Query>();
	
	@OneToOne(mappedBy = "transporter")
	private Rating rating;
	
	
	
	public Transporter(String email) {
		super();
		this.email = email;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Transporter(String email, String transporter_id, String transporter_firm_name, String password,
			String transporter_address, String mobile, String transporter_pan_no, String transporter_gst_no,
			Blob idproof, boolean verify, List<Vehicle> vehicle, List<Deals> deals, List<Query> query, Rating rating) {
		super();
		this.email = email;
		this.transporter_id = transporter_id;
		this.transporter_firm_name = transporter_firm_name;
		this.password = password;
		this.transporter_address = transporter_address;
		this.mobile = mobile;
		this.transporter_pan_no = transporter_pan_no;
		this.transporter_gst_no = transporter_gst_no;
		this.idproof = idproof;
		this.verify = verify;
		this.vehicle = vehicle;
		this.deals = deals;
		this.query = query;
		this.rating = rating;
	}
	public Transporter(String transporter_id, String transporter_firm_name, String email, String password,
			String transporter_address, String mobile, String transporter_pan_no, String transporter_gst_no,
			Blob idproof, List<Vehicle> vehicle, List<Deals> deals, List<Query> query) {
		super();
		this.transporter_id = transporter_id;
		this.transporter_firm_name = transporter_firm_name;
		this.email = email;
		this.password = password;
		this.transporter_address = transporter_address;
		this.mobile = mobile;
		this.transporter_pan_no = transporter_pan_no;
		this.transporter_gst_no = transporter_gst_no;
		this.idproof = idproof;
		this.vehicle = vehicle;
		this.deals = deals;
		this.query = query;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public List<Deals> getDeals() {
		return deals;
	}
	public void setDeals(List<Deals> deals) {
		this.deals = deals;
	}
	public String getTransporter_id() {
		return transporter_id;
	}
	public void setTransporter_id(String transporter_id) {
		this.transporter_id = transporter_id;
	}
	public String getTransporter_firm_name() {
		return transporter_firm_name;
	}
	public void setTransporter_firm_name(String transporter_firm_name) {
		this.transporter_firm_name = transporter_firm_name;
	}
	public String getTransporter_address() {
		return transporter_address;
	}
	public void setTransporter_address(String transporter_address) {
		this.transporter_address = transporter_address;
	}
	public String getTransporter_pan_no() {
		return transporter_pan_no;
	}
	public void setTransporter_pan_no(String transporter_pan_no) {
		this.transporter_pan_no = transporter_pan_no;
	}
	public String getTransporter_gst_no() {
		return transporter_gst_no;
	}
	public void setTransporter_gst_no(String transporter_gst_no) {
		this.transporter_gst_no = transporter_gst_no;
	}
	public Blob getIdproof() {
		return idproof;
	}
	public void setIdproof(Blob idproof) {
		this.idproof = idproof;
	}
	
	
	public List<Query> getQuery() {
		return query;
	}
	public void setQuery(List<Query> query) {
		this.query = query;
	}
	
	public Transporter() {
		super();
	}
	
	
	
}
