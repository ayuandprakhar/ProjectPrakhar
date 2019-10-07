package wp.javaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Deals;
import wp.javaproject.entities.Query;
import wp.javaproject.entities.Transporter;
import wp.javaproject.entities.User;
import wp.javaproject.service.DealServiceInterface;
import wp.javaproject.service.QueryServiceInterface;
import wp.javaproject.service.TransporterServiceInterface;
import wp.javaproject.service.UserServiceInterface;

@Controller
public class QueryController {

	@Autowired
	QueryServiceInterface queryService;
	
	@Autowired
	DealServiceInterface dealService;
	
	@Autowired
	TransporterServiceInterface transporterService;
	
	@Autowired
	UserServiceInterface userService;
	
	@RequestMapping("raisequery")
	public ModelAndView raiseQuery(@RequestParam("number") String deal_no)
	{
		Deals deal= dealService.getDealById(deal_no);
		ModelAndView mv= new ModelAndView("query");
		mv.addObject("query", new Query());
		mv.addObject("deal", deal);
		return mv;
	}
	
	@RequestMapping("submitquery")
	public ModelAndView submitQuery(@ModelAttribute("query") Query query)
	{
		queryService.addQuery(query);
		ModelAndView mv= new ModelAndView("succesquery");
		return mv;
		
	}
	
	@RequestMapping("respondquery")
	public ModelAndView submitResponse(@ModelAttribute("query") Query query)
	{
		queryService.updateQuery(query);
		ModelAndView mv= new ModelAndView("successquery");
		return mv;
	}
	
	@RequestMapping("viewquries")
	public ModelAndView viewMyQueries(@SessionAttribute("email") String email)
	{
		Transporter transporter= transporterService.getTransporterById(email);
		List<Query> query=queryService.getQueryResponseFromTransporter(email);
		ModelAndView mv= new ModelAndView("view_queries");
		mv.addObject("transporter", transporter);
		mv.addObject("query", query);
		return mv;
	}
	
	@RequestMapping("sendresponse")
		public ModelAndView response(@RequestParam("number") String query_id)
		{
			Query query= queryService.getQueryByNo(query_id);
			ModelAndView mv = new ModelAndView("query_response");
			mv.addObject("query", query);
			return mv;
		}
	
	@RequestMapping("viewresponse")
	public ModelAndView myResponse(@SessionAttribute("email") String email)
	{
		User user= userService.getUserById(email);
		List<Query> query=queryService.getQueryFromUser(email);
		ModelAndView mv = new ModelAndView("response");
		mv.addObject("user", user);
		mv.addObject("query", query);
		return mv;
	}
	
}
