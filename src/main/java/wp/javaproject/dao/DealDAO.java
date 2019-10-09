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

import wp.javaproject.entities.Deals;

@Repository
public class DealDAO implements DealDAOInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addDeal(Deals deal) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(deal);
		tr.commit();
		session.close();
	}

	public void removeDeal(String deal_no) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Deals deals= session.get(Deals.class, deal_no);
		session.delete(deals);
		tr.commit();
		session.close();
	}

	public List<Deals> getAllDeals() {
		Session session= sessionFactory.openSession();
		Criteria cr= session.createCriteria(Deals.class);
		List<Deals> deals=cr.list();
		session.close();
		return deals;
	}

	public List<Deals> getDealsByTransporter(String email) {
		Session session= sessionFactory.openSession();
		Criteria cr= session.createCriteria(Deals.class);
		Criterion crt= Restrictions.eq("transporter.email", email);
		cr.add(crt);
		List<Deals> deals= cr.list();
		session.close();
		return deals;
	}

	public Deals getDealById(String deal_no) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Deals deal= session.get(Deals.class, deal_no);
		tr.commit();
		session.close();
		return deal;
	}

	public void updateDeal(Deals deal) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(deal);
		tr.commit();
		session.close();
	}

}
