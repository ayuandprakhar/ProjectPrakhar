package wp.javaproject.service;

import java.util.List;

import wp.javaproject.entities.User;

public interface UserServiceInterface {

	public void insertUser(User user);
	public void removeUser(String email);
	public void updateUser(User user);
	public User getUserById(String email);
	public List<User> getAllUser();
	public User verifyUser(User user);
}
