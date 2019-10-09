package wp.javaproject.service;

public interface RatingServiceInterface {
	public void rateTransporter(int value, String email);
	public int getRating(String email);
}
