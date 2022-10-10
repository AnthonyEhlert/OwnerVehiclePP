import java.time.LocalDate;
import java.util.List;

import controller.OwnerHelper;
import controller.VehicleHelper;
import model.Owner;
import model.Vehicle;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 7, 2022
 */
public class OwnerTester {
	
	public static void main(String[] args) {

		System.out.println("Test 1");
		//creating two owners and printing the details
		Owner boris = new Owner("Boris", "Schwartz");
		Owner vivian = new Owner("Vivian", "Dass");
		
		System.out.println(boris.toString());
		System.out.println(vivian.toString());
		
		System.out.println("Test 2");
		//using a helper to add the shopper to the OwnerVehiclePP database
		//and then printing from there
		OwnerHelper oh = new OwnerHelper();
		
		oh.insertOwner(boris);
		oh.insertOwner(vivian);
		
		List<Owner> allOwners = oh.showAllOwners();
		for(Owner o: allOwners) {
			System.out.println(o.toString());
		}
		
		System.out.println("Test 3");
		//using helper to delete record and print 2nd owner vivian
		oh.deleteOwner(boris);
		System.out.println("Deleted Boris");
		
		allOwners = oh.showAllOwners();
		for(Owner o: allOwners) {
			System.out.println(o.toString());
		}
		
		System.out.println("Temp test");
		//printing out string of list of vehicles connected to owner object
		
		LocalDate today = LocalDate.now();
		LocalDate yesterday = LocalDate.of(2022, 10, 6);
		
		Vehicle redTruck = new Vehicle(vivian, today, "Truck", "Red");
		Vehicle blackCar = new Vehicle(vivian, yesterday, "Car", "Black");
		VehicleHelper vh = new VehicleHelper();
		
		vh.insertNewVehicle(redTruck);
		vh.insertNewVehicle(blackCar);
		
		allOwners = oh.showAllOwners();
		for(Owner o: allOwners) {
			for(Vehicle v: o.getListOfVehicles()) {
				System.out.println(v.getColor());
			}
		}
		
	}

}
