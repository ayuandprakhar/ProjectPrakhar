package wp.javaproject.dao;

import java.util.List;

import wp.javaproject.entities.Vehicle;

public interface VehicleDAOInterface {
	public void insertVehicle(Vehicle vehicle);
	public void removeVehicle(String number);
	public void updateVehicle(Vehicle vehicle);
	public Vehicle getVehicleById(String number);
	public List<Vehicle> getAllVehicle(String email);
}
