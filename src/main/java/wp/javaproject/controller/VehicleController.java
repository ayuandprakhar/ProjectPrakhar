package wp.javaproject.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Transporter;
import wp.javaproject.entities.Vehicle;
import wp.javaproject.service.VehicleServiceInterface;

@Controller
public class VehicleController {
	@Autowired
	VehicleServiceInterface vehicleService;
	
	@RequestMapping("addvehicle1")
	public ModelAndView showVehicleEntryForm()
	{
		ModelAndView mv= new ModelAndView("add_vehicle");
		mv.addObject("vehicle", new Vehicle());
		return mv;
	}
	
	@RequestMapping("showallvehicle")
	public ModelAndView showAllVehicles(@SessionAttribute("email") String email)
	{
		List<Vehicle> vehicle= vehicleService.getAllVehicle(email);
		ModelAndView mv = new ModelAndView("vehicle_list");
		mv.addObject("vehicle", vehicle);
		return mv;
	}
	
	@RequestMapping("viewimage")
	public void readImage(@RequestParam("number") String number,HttpServletResponse response)
	{
		Vehicle vehicle=vehicleService.getVehicleById(number);
		Blob blob=vehicle.getRegistration();
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
	
	@RequestMapping("addvehicle")
	public ModelAndView addVehicle(@ModelAttribute("vehicle") Vehicle vehicle, @SessionAttribute("email") String email,@RequestParam("image") MultipartFile file )
	{
		Transporter transporter= new Transporter();
		transporter.setEmail(email);
		vehicle.setTransporter(transporter);
		try {
			byte[] b= file.getBytes();
			Blob blob = BlobProxy.generateProxy(b);
			vehicle.setRegistration(blob);
		} catch (IOException e) {
			e.printStackTrace();
		}
		vehicleService.insertVehicle(vehicle);
		ModelAndView mv = new ModelAndView("redirect:showallvehicle");
		return mv;
	}
}
