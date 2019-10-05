package wp.javaproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.javaproject.dao.VehicleDAO;
import wp.javaproject.dao.VehicleDAOInterface;
import wp.javaproject.entities.Vehicle;

@Service
public class VehicleService implements VehicleServiceInterface {
	
	@Autowired
	private VehicleDAOInterface vehicleDAO;
	
	public void insertVehicle(Vehicle vehicle) {
		vehicleDAO.insertVehicle(vehicle);
	}

	public void removeVehicle(String number) {
		vehicleDAO.removeVehicle(number);
	}

	public void updateVehicle(Vehicle vehicle) {
		vehicleDAO.updateVehicle(vehicle);
	}

	public Vehicle getVehicleById(String number) {
		return vehicleDAO.getVehicleById(number);
	}

	public List<Vehicle> getAllVehicle(String email) {
		return vehicleDAO.getAllVehicle(email);
	}

	public Map<String, String> getAllNumbers(String email) {
		
		return vehicleDAO.getAllNumbers(email);
	}
}
