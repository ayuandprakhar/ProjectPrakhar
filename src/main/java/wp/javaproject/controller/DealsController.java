package wp.javaproject.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Deals;
import wp.javaproject.entities.User;
import wp.javaproject.entities.Vehicle;
import wp.javaproject.service.DealServiceInterface;
import wp.javaproject.service.UserServiceInterface;
import wp.javaproject.service.VehicleServiceInterface;

@Controller
public class DealsController {

	@Autowired
	private DealServiceInterface dealService;
	
	@Autowired
	private VehicleServiceInterface vehicleService;
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	JavaMailSender mailSender;
	
	@RequestMapping("postdeal")
	public ModelAndView showDealForm(@SessionAttribute("email") String email)
	{
		ModelAndView mv= new ModelAndView("new_deal");
		mv.addObject("deal", new Deals());
		Map<String,String> number= vehicleService.getAllNumbers(email);
		Deals d = new Deals();
		mv.addObject("number", number);
		return mv;
	}
	
	@RequestMapping("adddeal")
	public ModelAndView addDeal(@ModelAttribute("deal") Deals deal)
	{
		dealService.addDeal(deal);
		sendEmail();
		ModelAndView mv= new ModelAndView("redirect:showalldeals");
		return mv;
	}
	
	@RequestMapping("showalldeals")
	public ModelAndView showAll(@SessionAttribute("email") String email)
	{
		List<Deals> deals= dealService.getDealsByTransporter(email);
		ModelAndView mv= new ModelAndView("transporter_deal");
		mv.addObject("deal", deals);
		return mv;
	}
	
	@RequestMapping("viewdealsadmin")
	public ModelAndView viewAllAdmin(@ModelAttribute("deal") Deals deal)
	{
		List<Deals> deals= dealService.getAllDeals();
		ModelAndView mv= new ModelAndView("admin_deal");
		mv.addObject("deal", deals);
		return mv;
	}
	
	@RequestMapping("viewdeals")
	public ModelAndView viewAll(@ModelAttribute("deal") Deals deal)
	{
		List<Deals> deals= dealService.getAllDeals();
		ModelAndView mv= new ModelAndView("deal_list");
		mv.addObject("deal", deals);
		return mv;
	}
	
	public void sendEmail(){
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		List<User> list = userService.getAllUserMails();
		String[] to=Arrays.copyOf(list.toArray(), list.toArray().length,String[].class);
		mailMessage.setTo(to);
		String subject="New Deal";
		mailMessage.setSubject(subject);
		String message="New Deal posted by transporter";
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}
	
	@RequestMapping("removedeal")
	public ModelAndView deleteDeal(@RequestParam("number") String number)
	{
		dealService.removeDeal(number);
		ModelAndView mv= new ModelAndView("redirect:viewdealsadmin");
		return mv;
	}
	
	@RequestMapping("openupdatedeal")
	public ModelAndView openUpdateDeal(@RequestParam("number") String number)
	{
		Deals deal=dealService.getDealById(number);
		ModelAndView mv= new ModelAndView("update_deal");
		mv.addObject("deal", deal);
		return mv;
	}
	
	@RequestMapping("updatedeal")
	public ModelAndView updateDeal(@ModelAttribute("deal") Deals deal)
	{
		dealService.updateDeal(deal);
		ModelAndView mv= new ModelAndView("redirect:showalldeals");
		return mv;
	}
}
