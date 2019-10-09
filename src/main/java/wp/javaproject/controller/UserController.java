package wp.javaproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.User;
import wp.javaproject.service.TransporterService;
import wp.javaproject.service.UserServiceInterface;

@Controller
@SessionAttributes(names = { "email", "username" })
public class UserController {
	@Autowired
	private UserServiceInterface userService;

	@RequestMapping("openregisteruser")
	public ModelAndView openRegistrationPage() {
		User user = new User();
		ModelAndView mv = new ModelAndView("user_registration");
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("adduser")
	public ModelAndView addNewUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors())
		{
			ModelAndView mv = new ModelAndView("user_registration");
			return mv;
		}
		userService.insertUser(user);
		ModelAndView mv = new ModelAndView("register_user_succesfull");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("update_user")
	public ModelAndView loadUpdationForm(@SessionAttribute("email") String email)
	{
		User user= userService.getUserById(email);
		ModelAndView mv = new ModelAndView("update_user");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("updateuser")
	public ModelAndView updateUser(@ModelAttribute("user") User user)
	{
		userService.updateUser(user);
		ModelAndView mv = new ModelAndView("userlist");
		return mv;
	}
	
	@RequestMapping("user_home")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("home_user");
		return mv;
	}
}
