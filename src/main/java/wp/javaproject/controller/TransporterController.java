package wp.javaproject.controller;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import wp.javaproject.entities.Transporter;
import wp.javaproject.service.TransporterServiceInterface;

@Controller
@SessionAttributes
public class TransporterController {
	@Autowired
	private TransporterServiceInterface transporterService;
	
	@RequestMapping("openregistertransporter")
	public ModelAndView openTRegistrationPage()
	{
		Transporter transporter= new Transporter();
		ModelAndView mv= new ModelAndView("transporter_registration");
		mv.addObject("transporter", transporter);
		return mv;
	}
	
	@RequestMapping("updatetransporter")
	public ModelAndView openUpdatePage(@SessionAttribute("email") String email)
	{
		Transporter transporter= transporterService.getTransporterById(email);
		ModelAndView mv = new ModelAndView("update_transporter");
		mv.addObject("transporter", transporter);
		return mv;
	}
	
	@RequestMapping("transporter_home")
	public ModelAndView transporterHome(@ModelAttribute("transporter") Transporter transporter)
	{
		ModelAndView mv= new ModelAndView("home_transporter");
		return mv;
	}
	
	
	@RequestMapping("addtransporter")
	public ModelAndView addNewTransporter(@ModelAttribute("transporter") Transporter transporter,@RequestParam("image") MultipartFile file)
	{
		try {
			byte[] b= file.getBytes();
			Blob blob= BlobProxy.generateProxy(b);
			transporter.setIdproof(blob);
			transporter.setVerify(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		transporterService.insertTransporter(transporter);
		ModelAndView mv= new ModelAndView("register_transporter_succesfull");
		return mv;
	}
	
	@RequestMapping("updateTransporter")
	public ModelAndView updateTransporter(@ModelAttribute("transporter") Transporter transporter,@RequestParam("image") MultipartFile file)
	{
		try {
			byte[] b= file.getBytes();
			Blob blob= BlobProxy.generateProxy(b);
			transporter.setIdproof(blob);
			transporter.setVerify(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		transporterService.updateTransporter(transporter);
		ModelAndView mv= new ModelAndView("update_transporter_succesfull");
		return mv;
	}
	
}
