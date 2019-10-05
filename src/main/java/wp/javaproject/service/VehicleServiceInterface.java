package wp.javaproject.service;

import java.util.List;

import wp.javaproject.entities.Vehicle;

public interface VehicleServiceInterface {
	public void insertVehicle(Vehicle vehicle);
	public void removeVehicle(String number);
	public void updateVehicle(Vehicle vehicle);
	public Vehicle getVehicleById(String number);
	public List<Vehicle> getAllVehicle(String email);
}
