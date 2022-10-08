package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Vehicle;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Oct 8, 2022
 */
public class VehicleHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OwnerVehiclePP");
	
	public void insertNewVehicle(Vehicle v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Vehicle> showAllVehicles() {
		EntityManager em = emfactory.createEntityManager();
		List<Vehicle> allVehicles = em.createQuery("SELECT v FROM Vehicle v").getResultList();
		return allVehicles;
	}
	
	public void deleteVehicle(Vehicle toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Vehicle> typedQuery = em.createQuery("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.id = :selectedId", Vehicle.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Vehicle result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Vehicle searchForVehicleById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Vehicle found = em.find(Vehicle.class, tempId);
		em.close();
		return found;
	}
	
	public void updateVehicle(Vehicle toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
