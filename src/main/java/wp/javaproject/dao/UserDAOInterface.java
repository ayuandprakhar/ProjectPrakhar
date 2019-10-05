package wp.javaproject.dao;

import java.util.List;

import wp.javaproject.entities.User;

public interface UserDAOInterface {
	public void insertUser(User user);
	public void removeUser(String email);
	public void updateUser(User user);
	public User getUserById(String email);
	public List<User> getAllUser();
	public User verifyUser(User user);
}
