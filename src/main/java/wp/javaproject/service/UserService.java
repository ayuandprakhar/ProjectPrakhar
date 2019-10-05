package wp.javaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.javaproject.dao.UserDAO;
import wp.javaproject.dao.UserDAOInterface;
import wp.javaproject.entities.User;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserDAOInterface userDAO;
	
	public void insertUser(User user) {
		userDAO.insertUser(user);
	}

	public void removeUser(String email) {
		userDAO.removeUser(email);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public User getUserById(String email) {
		return userDAO.getUserById(email);
	}

	public List<User> getAllUser() {
		
		return userDAO.getAllUser();
	}

	public User verifyUser(User user) {
		return userDAO.verifyUser(user);
	}
	
	

}
