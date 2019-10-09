package wp.javaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.javaproject.dao.RatingDAOInterface;

@Service
public class RatingService implements RatingServiceInterface {

	@Autowired
	RatingDAOInterface ratingDAO;
	
	public void rateTransporter(int value, String email) {
		ratingDAO.rateTransporter(value, email);
	}

	public int getRating(String email) {
		return ratingDAO.getRating(email);
	}

}
