package wp.javaproject.controller;

import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Rating;
import wp.javaproject.entities.Transporter;
import wp.javaproject.entities.Vehicle;
import wp.javaproject.service.DealServiceInterface;
import wp.javaproject.service.RatingServiceInterface;
import wp.javaproject.service.TransporterServiceInterface;
import wp.javaproject.service.VehicleServiceInterface;

@Controller
public class AdminController {
	
	@Autowired
	TransporterServiceInterface transporterService;
	
	@Autowired
	VehicleServiceInterface vehicleService;
	
	@Autowired
	DealServiceInterface dealService;
	
	@Autowired
	RatingServiceInterface ratingService;
	
	@RequestMapping("viewtransporter")
	public ModelAndView showTransporters()
	{
		List<Transporter> transporter= transporterService.getAllTransporter();
		ModelAndView mv=new ModelAndView("transporter_list");
		mv.addObject("transporters", transporter);
		return mv;
	}
	
	@RequestMapping("showimage")
	public void readImage(@RequestParam("number") String number,HttpServletResponse response)
	{
		Transporter transporter=transporterService.getTransporterById(number);
		Blob blob= transporter.getIdproof();
		try {
		byte[] b= null;
		b= blob.getBytes(1, (int)blob.length());
		ServletOutputStream sos = response.getOutputStream();
		sos.write(b);
		sos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping("viewimage")
	public void loadImage(@RequestParam("number") String number,HttpServletResponse response)
	{
		Vehicle vehicle= vehicleService.getVehicleById(number);
		Blob blob= vehicle.getRegistration();
		try {
		byte[] b= null;
		b= blob.getBytes(1, (int)blob.length());
		ServletOutputStream sos = response.getOutputStream();
		sos.write(b);
		sos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping("allvehicles")
	public ModelAndView showVehicles()
	{
		List<Vehicle> vehicle= vehicleService.getAllVehicles();
		ModelAndView mv= new ModelAndView("vehicle_list_admin");
		mv.addObject("vehicle", vehicle);
		return mv;
	}
	
	@RequestMapping("approvetransporter")
	public ModelAndView approveTransporter(@RequestParam("number") String number)
	{
		Transporter transporter= transporterService.getTransporterById(number);
		transporter.setVerify(true);
		transporterService.updateTransporter(transporter);
		ModelAndView mv= new ModelAndView("redirect:viewtransporter");
		return mv;
	}
	
	@RequestMapping("rejecttransporter")
	public ModelAndView rejectTransporter(@RequestParam("number") String number)
	{
		Transporter transporter= transporterService.getTransporterById(number);
		transporter.setVerify(false);
		transporterService.updateTransporter(transporter);
		ModelAndView mv= new ModelAndView("redirect:viewtransporter");
		return mv;
	}
	
	@RequestMapping("removetransporter")
	public ModelAndView deleteTransporter(@RequestParam("number") String email)
	{
		transporterService.removeTransporter(email);
		ModelAndView mv= new ModelAndView("delete_transporter");
		return mv;
	}
	
	@RequestMapping("viewratings")
	public ModelAndView showRating()
	{
		List<Rating> rating= ratingService.getAllRating();
		ModelAndView mv= new ModelAndView("view_rating");
		mv.addObject("rating",rating);
		return mv;
	}
	
	@RequestMapping("approvevehicle")
	public ModelAndView approveVehicle(@RequestParam("number") String number)
	{
		Vehicle vehicle= vehicleService.getVehicleById(number);
		vehicle.setVerify(true);
		vehicleService.updateVehicle(vehicle);
		ModelAndView mv= new ModelAndView("redirect:allvehicles");
		return mv;
	}
	
	@RequestMapping("rejectvehicle")
	public ModelAndView rejectVehicle(@RequestParam("number") String number)
	{
		Vehicle vehicle= vehicleService.getVehicleById(number);
		vehicle.setVerify(false);
		vehicleService.updateVehicle(vehicle);
		ModelAndView mv= new ModelAndView("redirect:allvehicles");
		return mv;
	}
	
}
