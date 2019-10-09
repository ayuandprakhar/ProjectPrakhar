package wp.javaproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.User;

@Repository
public class UserDAO implements UserDAOInterface {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertUser(User user) {
	Session session = sessionFactory.openSession();
	Transaction tr= session.beginTransaction();
	session.save(user);
	tr.commit();
	session.close();
	}

	public void removeUser(String email) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		User user = session.get(User.class, email);
		session.delete(user);
		tr.commit();
		session.close();
		}

	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		session.update(user);
		tr.commit();
		session.close();
	}

	public User getUserById(String email) {
		Session session = sessionFactory.openSession();
		Transaction tr= session.beginTransaction();
		User user = session.get(User.class, email);
		tr.commit();
		session.close();
		return user;
	}

	public List<User> getAllUser() {
		Session session = sessionFactory.openSession();
		Criteria cr= session.createCriteria(User.class);
		List<User> user=cr.list();
		return user;
	}

	public User verifyUser(User user) {
		Session session = sessionFactory.openSession();
		User user1=session.get(User.class, user.getEmail());

		if(user1==null)
		{
			return null;
		}
		else
		{
			if(user.getPassword().equals(user1.getPassword()))
			{
				return user1;
			}
			else
			{
				return null;
			}
		}
	}

	public List<User> getAllUserMails() {
		Session session = sessionFactory.openSession();
		Criteria cr= session.createCriteria(User.class);
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.property("email"));
		cr.setProjection(projection);
		List<User> user=cr.list();
		return user;
	}

	
		
	}

