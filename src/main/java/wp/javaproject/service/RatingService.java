package wp.javaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.javaproject.dao.RatingDAOInterface;
import wp.javaproject.entities.Rating;

@Service
public class RatingService implements RatingServiceInterface {

	@Autowired
	RatingDAOInterface ratingDAO;
	
	public void rateTransporter(int value, String email) {
		ratingDAO.rateTransporter(value, email);
	}

	public List<Rating> getRating(String email) {
		return ratingDAO.getRating(email);
	}

	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingDAO.getAllRatings();
	}

}
