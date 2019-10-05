package wp.javaproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Deals;
import wp.javaproject.entities.Vehicle;
import wp.javaproject.service.DealServiceInterface;
import wp.javaproject.service.VehicleServiceInterface;

@Controller
public class DealsController {

	@Autowired
	DealServiceInterface dealService;
	
	@Autowired
	VehicleServiceInterface vehicleService;
	
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
		ModelAndView mv= new ModelAndView("redirect:showalldeals");
		return mv;
	}
	
	@RequestMapping("showalldeals")
	public ModelAndView showAll(@ModelAttribute("deal") Deals deal)
	{
		List<Deals> deals= dealService.getAllDeals();
		ModelAndView mv= new ModelAndView("deal_list");
		mv.addObject("deal", deals);
		return mv;
	}
	
	
}
