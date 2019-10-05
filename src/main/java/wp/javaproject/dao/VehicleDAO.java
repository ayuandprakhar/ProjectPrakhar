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

import wp.javaproject.entities.Vehicle;

@Repository
public class VehicleDAO implements VehicleDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		session.save(vehicle);
		tr.commit();
		session.close();

	}

	public void removeVehicle(String number) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		Vehicle vehicle=session.get(Vehicle.class, number);
		tr.commit();
		session.close();
	}

	public void updateVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		session.update(vehicle);
		tr.commit();
		session.close();
	}

	public Vehicle getVehicleById(String number) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		Vehicle vehicle =session.get(Vehicle.class,number);
		tr.commit();
		session.close();
		return vehicle;
	}

	public List<Vehicle> getAllVehicle(String email) {
		Session session = sessionFactory.openSession();
		Criteria cr= session.createCriteria(Vehicle.class);
		Criterion crt= Restrictions.eq("transporter.email", email);
		cr.add(crt);
		List<Vehicle> vehicle=cr.list();
		session.close();
		return vehicle;
	}

}
