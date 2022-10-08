package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;
import model.Vehicle;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 7, 2022
 */
public class OwnerHelper {

	//global instance of EntityManagerFactory
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("OwnerVehiclePP");

	//shows all method
	public List<Owner> showAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o", Owner.class).getResultList();
		return allOwners;
	}
	
	//insert, delete, and edit methods
	public void insertOwner(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteOwner(Owner toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select ow from Owner ow where ow.firstName = :selectedFirstName and ow.lastName = :selectedLastName", Owner.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedLastName", toDelete.getLastName());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Owner result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateOwner(Owner toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	//searching methods for each of the 4 parameters
	public Owner searchForOwnerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Owner found = em.find(Owner.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Owner> searchForOwnerByFirstName(String firstName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select li from Owner li where li.firstName = :selectedFirstName", Owner.class);
		typedQuery.setParameter("selectedFirstName", firstName);
		List<Owner> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
	
	public List<Owner> searchForOwnerByLastName(String lastName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select li from Owner li where li.lastName = :selectedLastName", Owner.class);
		typedQuery.setParameter("selectedLastName", lastName);
		List<Owner> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
	
	public List<Owner> searchForOwnerByListOfVehicles(List<Vehicle> listOfVehicles) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select li from Owner li where li.listOfVehicles = :selectedListOfVehicles", Owner.class);
		typedQuery.setParameter("selectedListOfVehicles", listOfVehicles);
		List<Owner> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
	
	//clean up
	public void cleanUp(){
		emfactory.close();
	}

}
