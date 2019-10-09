package wp.javaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import wp.javaproject.service.RatingServiceInterface;

@Controller
public class RatingController {

	@Autowired RatingServiceInterface ratingService;
	
	@RequestMapping("rateTransporter")
	public void rate(@RequestParam("email") String email,@RequestParam("ratingValue") int value)
	{
		ratingService.rateTransporter(value, email);
	}
}
