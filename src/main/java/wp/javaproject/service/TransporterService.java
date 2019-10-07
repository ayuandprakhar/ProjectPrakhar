package wp.javaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.javaproject.dao.TransporterDAO;
import wp.javaproject.dao.TransporterDAOInterface;
import wp.javaproject.dao.VehicleDAO;
import wp.javaproject.entities.Transporter;

@Service
public class TransporterService implements TransporterServiceInterface {

	@Autowired
	private TransporterDAOInterface transporterDAO;
	
	public void insertTransporter(Transporter transporter) {
		transporterDAO.insertTransporter(transporter);
	}

	public void removeTransporter(String id) {
		transporterDAO.removeTransporter(id);
	}

	public void updateTransporter(Transporter transporter) {
		transporterDAO.updateTransporter(transporter);
	}

	public Transporter getTransporterById(String id) {
		return transporterDAO.getTransporterById(id);
	}

	public List<Transporter> getAllTransporter() {
		return transporterDAO.getAllTransporter();
	}

	public Transporter verifyTransporter(Transporter transporter) {
		// TODO Auto-generated method stub
		return transporterDAO.verifyTransporter(transporter);
	}

}
