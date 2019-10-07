package wp.javaproject.dao;

import java.util.List;

import wp.javaproject.entities.Transporter;

public interface TransporterDAOInterface {
	public void insertTransporter(Transporter transporter);
	public void removeTransporter(String id);
	public void updateTransporter(Transporter transporter);
	public Transporter getTransporterById(String id);
	public List<Transporter> getAllTransporter();
	public Transporter verifyTransporter(Transporter transporter);
}
