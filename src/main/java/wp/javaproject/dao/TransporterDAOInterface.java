package wp.javaproject.dao;

import java.util.List;

import wp.javaproject.entities.Transporter;

public interface TransporterDAOInterface {
	public void insertTransporter(Transporter transporter);
	public void removeTransporter(int id);
	public void updateTransporter(Transporter transporter);
	public Transporter getTransporterById(int id);
	public List<Transporter> getAllTransporter();
	public Transporter verifyTransporter(Transporter transporter);
}
