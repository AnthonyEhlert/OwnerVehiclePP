package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 7, 2022
 */

@Entity
@Table(name = "owners")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Vehicle> listOfVehicles;
	
	public Owner() {
		super();
	}
	
	public Owner(int id, String firstName, String lastName, List<Vehicle> listOfVehicles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.listOfVehicles = listOfVehicles;
	}

	public Owner(String firstName, String lastName, List<Vehicle> listOfVehicles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.listOfVehicles = listOfVehicles;
	}

	public Owner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Vehicle> getListOfVehicles() {
		return listOfVehicles;
	}

	public void setListOfVehicles(List<Vehicle> listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", listOfVehicles=" + listOfVehicles + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
}
