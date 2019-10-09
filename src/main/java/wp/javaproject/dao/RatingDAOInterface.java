package wp.javaproject.dao;

public interface RatingDAOInterface {

	public void rateTransporter(int value, String email);
	public int getRating(String email);
}
