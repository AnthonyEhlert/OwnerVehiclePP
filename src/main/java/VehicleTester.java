import java.time.LocalDate;
import java.util.List;

import controller.VehicleHelper;
import model.Vehicle;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */
public class VehicleTester {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		LocalDate yesterday = LocalDate.of(2022, 10, 6);
		
		Owner janeSmith = new Owner("Jane", "Smith");
		Owner johnDoe = new Owner("John", "Doe");
		
		Vehicle redTruck = new Vehicle(janeSmith, today, "Truck", "Red");
		Vehicle blackCar = new Vehicle(johnDoe, yesterday, "Car", "Black");
		
		VehicleHelper vh = new VehicleHelper();
		
		vh.insertNewVehicle(redTruck);
		vh.insertNewVehicle(blackCar);
		
		List<Vehicle> allVehicles = vh.showAllVehicles();
		
		for (Vehicle v: allVehicles) {
			System.out.println(v.toString());
		}
		
	}

}
