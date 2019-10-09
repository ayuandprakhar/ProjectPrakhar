package wp.javaproject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

@Entity
public class User {
@Id
private String email;
private String user_id;

@Pattern(regexp="[a-zA-Z]*", message="Only Alphabates Allowed")
private String user_name;

private String password;

@Pattern(regexp="[0-9]*", message="Only Numbers Allowed")
private String mobile;
private String address;

@OneToMany(mappedBy = "user",orphanRemoval = true, cascade = CascadeType.PERSIST)
private List<Query> query= new ArrayList<Query>();

public List<Query> getQuery() {
	return query;
}
public void setQuery(List<Query> query) {
	this.query = query;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}



public User(String user_id, String user_name, String password, String email, String mobile, String address,
		List<Query> query) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.password = password;
	this.email = email;
	this.mobile = mobile;
	this.address = address;
	this.query = query;
}

public User(String user_id, String user_name, String password, String email, String mobile, String address) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.password = password;
	this.email = email;
	this.mobile = mobile;
	this.address = address;
}

public User() {
	super();
}


}
