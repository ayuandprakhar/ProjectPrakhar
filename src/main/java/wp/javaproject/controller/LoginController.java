package wp.javaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Transporter;
import wp.javaproject.entities.User;
import wp.javaproject.service.TransporterService;
import wp.javaproject.service.UserServiceInterface;

@Controller
@SessionAttributes(names = {"email","username"})
public class LoginController {

	@Autowired
	private UserServiceInterface userService;

	@Autowired
	private TransporterService transporterService;
	
	@RequestMapping("verify")
	public ModelAndView verifyUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("type") String type) {
		if (type.equalsIgnoreCase("admin")) {
			if (email.equals("admin") && password.equals("admin")) {
				ModelAndView mv = new ModelAndView("home_admin");
				mv.addObject("email", email);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("wrong_credentials");
				return mv;
			}
		} else if (type.equalsIgnoreCase("user")) {
			User u = new User();
			u.setEmail(email);
			u.setPassword(password);
			User user = userService.verifyUser(u);
			if (user != null) {
				ModelAndView mv = new ModelAndView("home_user");
				mv.addObject("email", email);
				mv.addObject("username", user.getUser_name());
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("wrong_credentials");
				return mv;
			}

		} else {
			Transporter t = new Transporter();
			t.setEmail(email);
			t.setPassword(password);
			Transporter transporter = transporterService.verifyTransporter(t);
			if (transporter != null) {
				if (transporter.isVerify()) {
					ModelAndView mv = new ModelAndView("home_transporter");
					mv.addObject("email", email);
					mv.addObject("username", transporter.getTransporter_firm_name());
					return mv;
				}
				else
				{
					ModelAndView mv = new ModelAndView("Approval");
					return mv;
				}
			} else {
				ModelAndView mv = new ModelAndView("wrong_credentials");
				return mv;
			}
		}

	}
}
