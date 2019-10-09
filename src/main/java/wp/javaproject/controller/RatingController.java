package wp.javaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import wp.javaproject.service.RatingServiceInterface;

@Controller
public class RatingController {

	@Autowired RatingServiceInterface ratingService;
	
	@RequestMapping("rateTransporter")
	//@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity rate(@RequestParam("email") String email,@RequestParam("ratingValue") int value)
	{
		ratingService.rateTransporter(value, email);
		return new ResponseEntity(HttpStatus.OK);
	}
}
