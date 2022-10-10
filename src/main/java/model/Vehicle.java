package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Oct 6, 2022
 */

@Entity
@Table(name = "vehicle_info")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE})
	private Owner owner;
	
	private LocalDate dateOfPurchase;
	private String type;
	private String color;
	
	//default no-arg constructor
	public Vehicle() {
		super();
	}
	
	//helper constructors
	public Vehicle(Owner owner, LocalDate date, String type, String color) {
		super();
		this.owner = owner;
		this.dateOfPurchase = date;
		this.type = type;
		this.color = color;
	}
	
	public Vehicle(Owner owner, LocalDate date, String type) {
		super();
		this.owner = owner;
		this.dateOfPurchase = date;
		this.type = type;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", owner=" + owner + ", dateOfPurchase=" + dateOfPurchase + ", type=" + type
				+ ", color=" + color + "]";
	}
	
	
}
