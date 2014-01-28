package com.transpro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.transpro.domain.Driver;

@Stateless

public class DriverManager {

	
	@PersistenceContext
	EntityManager em ;
	
	//private List<Driver> drivers = new ArrayList<Driver>();
	
	public void addDriver(Driver driver ){
	
		driver.setId(null);
		driver.setAvailable(true);
		em.persist(driver);
		
	
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Driver> getAllDrivers(){
		return em.createNamedQuery("drivers.all").getResultList();
	}
	
	/*public Driver getById(int id){
		Driver c = drivers.get(id);
		if(c!=null)
			return c; 
		return null;
	}*/
	
	public void deleteDriver(Driver d){
				
		d = em.find(Driver.class, d.getId());
		em.remove(d);
		
		
	}

	
	
}
