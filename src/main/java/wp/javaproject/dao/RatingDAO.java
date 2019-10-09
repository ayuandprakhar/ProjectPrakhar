package wp.javaproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public int getRating(String email) {
		
		return 0;
	}

}
