package wp.javaproject.controller;

import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Transporter;
import wp.javaproject.entities.Vehicle;
import wp.javaproject.service.DealServiceInterface;
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
		transporter.setVerify(true);
		transporterService.updateTransporter(transporter);
		ModelAndView mv= new ModelAndView("redirect:viewtransporter");
		return mv;
	}
}
