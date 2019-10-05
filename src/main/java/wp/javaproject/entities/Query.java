package wp.javaproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Query {
@Id
private String query_id;
private String question;
private String resp;

@ManyToOne
private User user;

@ManyToOne
private Transporter transporter;

public String getQuery_id() {
	return query_id;
}

public void setQuery_id(String query_id) {
	this.query_id = query_id;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getResp() {
	return resp;
}

public void setResp(String resp) {
	this.resp = resp;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Transporter getTransporter() {
	return transporter;
}

public void setTransporter(Transporter transporter) {
	this.transporter = transporter;
}

public Query(String query_id, String question, String resp, User user, Transporter transporter) {
	super();
	this.query_id = query_id;
	this.question = question;
	this.resp = resp;
	this.user = user;
	this.transporter = transporter;
}

public Query() {
	super();
}


}
