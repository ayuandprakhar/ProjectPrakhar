package wp.javaproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wp.javaproject.entities.Transporter;

@Repository
public class TransporterDAO implements TransporterDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertTransporter(Transporter transporter) {
	Session session = sessionFactory.openSession();
	Transaction tr= session.beginTransaction();
	session.save(transporter);
	tr.commit();
	session.close();
	}

	public void removeTransporter(int id) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		Transporter transporter = session.get(Transporter.class, id);
		tr.commit();
		session.close();
	}

	public void updateTransporter(Transporter transporter) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		session.update(transporter);
		tr.commit();
		session.close();
	}

	public Transporter getTransporterById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		Transporter transporter = session.get(Transporter.class, id);
		tr.commit();
		session.close();
		return transporter;
	}

	public List<Transporter> getAllTransporter() {
		Session session = sessionFactory.openSession();
		Criteria cr= session.createCriteria(Transporter.class);
		List<Transporter> transporter=cr.list();
		return transporter;
	}

	public Transporter verifyTransporter(Transporter transporter) {
		Session session= sessionFactory.openSession();
		Transporter transporter1=session.get(Transporter.class, transporter.getEmail());
		if(transporter1==null)
		{
			return null;
		}
		else
		{
			if(transporter.getPassword().equals(transporter1.getPassword()))
			{
				return transporter1;
			}
			else
			{
				return null;
			}
		}
		}

}
