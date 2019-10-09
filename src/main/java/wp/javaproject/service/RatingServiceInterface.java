package wp.javaproject.service;

import java.util.List;

import wp.javaproject.entities.Rating;

public interface RatingServiceInterface {
	public void rateTransporter(int value, String email);
	public List<Rating> getRating(String email);
	public List<Rating> getAllRating();
}
