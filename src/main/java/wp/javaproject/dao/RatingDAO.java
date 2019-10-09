package wp.javaproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wp.javaproject.entities.Rating;
import wp.javaproject.entities.Transporter;

@Repository
public class RatingDAO implements RatingDAOInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	public void rateTransporter(int value, String email) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Transporter transporter = session.get(Transporter.class, email);
		if(transporter.getRating()!=null)
		{
			int rate= transporter.getRating().getId();
			Rating rating= session.get(Rating.class, rate);
			value=(rating.getValue()+value)/2;
			rating.setValue(value);
			int count=rating.getCount()+1;
			rating.setCount(count);
			session.saveOrUpdate(rating);
		}
		else
		{
			Rating rating= new Rating();
			rating.setCount(1);
			rating.setValue(value);
			rating.setTransporter(new Transporter(email));
			session.save(rating);
		}
		tr.commit();
		session.close();

	}

	public List<Rating> getRating(String email) {
		Session session= sessionFactory.openSession();
		Criteria cr= session.createCriteria(Rating.class);
		Criterion crt= Restrictions.eq("transporter.email", email);
		cr.add(crt);
		List<Rating> rating= cr.list();
		session.close();
		return rating;
	}

	public List<Rating> getAllRatings() {
		Session session= sessionFactory.openSession();
		Criteria cr= session.createCriteria(Rating.class);
		List<Rating> rating=cr.list();
		session.close();
		return rating;
	}
	
	

}
