package com.transpro.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.transpro.domain.Car;


@Stateless
public class CarManager {
	

	@PersistenceContext
	EntityManager em ;
	
	//private List<Car> cars = new ArrayList<Car>();
	
	public void addCar(Car car){
	
		car.setId(null);
		em.persist(car);
	}
	
	@SuppressWarnings("unchecked")
	public List<Car> getAllCars(){
		return em.createNamedQuery("cars.all").getResultList();
	}
	
/*	public Car getById(int id){
		Car c = cars.get(id);
		if(c!=null)
			return c; 
		return null;
	}*/
	
	public void deleteCar(Car c){
	
		c = em.find(Car.class, c.getId());
		em.remove(c);
		
	}

}
