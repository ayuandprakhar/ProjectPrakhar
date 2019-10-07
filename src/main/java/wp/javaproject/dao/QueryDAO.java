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

import wp.javaproject.entities.Query;

@Repository
public class QueryDAO implements QueryDAOInterface {
	@Autowired
	SessionFactory sessionFactory;
	
	public void addQuery(Query query) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(query);
		tr.commit();
		session.close();	
	}

	public List<Query> getQueryFromUser(String email) {
		
		Session session= sessionFactory.openSession();
		Criteria cr= session.createCriteria(Query.class);
		Criterion crt= Restrictions.eq("user.email", email);
		cr.add(crt);
		List<Query> query= cr.list();
		session.close();
		return query;
	}

	public void updateQuery(Query query) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(query);
		tr.commit();
		session.close();

	}

	public List<Query> getQueryResponseFromTransporter(String email) {
		Session session= sessionFactory.openSession();
		Criteria cr= session.createCriteria(Query.class);
		Criterion crt= Restrictions.eq("transporter.email", email);
		cr.add(crt);
		List<Query> query= cr.list();
		session.close();
		return query;
	}

	public Query getQueryByNo(String query_id) {
		Session session= sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		Query query= session.get(Query.class, query_id);
		tr.commit();
		session.close();
		return query;
	}

}
