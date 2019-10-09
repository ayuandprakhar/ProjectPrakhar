package wp.javaproject.dao;

import java.util.List;

import wp.javaproject.entities.Rating;

public interface RatingDAOInterface {

	public void rateTransporter(int value, String email);
	public List<Rating> getRating(String email);
	public List<Rating> getAllRatings();
}
