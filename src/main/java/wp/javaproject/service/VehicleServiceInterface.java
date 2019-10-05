package wp.javaproject.service;

import java.util.List;
import java.util.Map;

import wp.javaproject.entities.Vehicle;

public interface VehicleServiceInterface {
	public void insertVehicle(Vehicle vehicle);
	public void removeVehicle(String number);
	public void updateVehicle(Vehicle vehicle);
	public Vehicle getVehicleById(String number);
	public List<Vehicle> getAllVehicle(String email);
	public Map<String, String> getAllNumbers(String email);
}
