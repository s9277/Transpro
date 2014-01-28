package com.transpro.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.xml.ws.api.tx.at.Transactional;
import com.transpro.domain.Car;
import com.transpro.domain.Driver;
import com.transpro.domain.Route;


@Stateless
public class RouteManager {
	
	@PersistenceContext
	private EntityManager em;
	
	//private List<Route> routes = new ArrayList<Route>();
	 
	
	@SuppressWarnings("unchecked")
	public List<Driver> getAvailableDrivers(){
		
		return em.createNamedQuery("drivers.available").getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Car> getAvailableCars(){
		return em.createNamedQuery("cars.available").getResultList(); 
		
	}
	
	
	public void createRoute(Long driverId, Long carId, Route route){
		
		Driver d = em.find(Driver.class, driverId);
		Car c = em.find(Car.class, carId);
		
		d.setAvailable(false);
		c.setAvailable(false);
		
		route.setDriver(d);
		route.setCar(c);
		
		
		route.setId(null);
		em.persist(route);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Route> getRoutes(){
		return em.createNamedQuery("routes.all").getResultList();
	}
	
	public void addRoute(Route route){
		route.setId(null);
		em.persist(route);
	}
	
	
	
	public void deleteRoute(Route r){
		em.find(Route.class,r.getId());
		em.find(Driver.class, r.getDriver().getId()).setAvailable(true);
		em.find(Car.class, r.getCar().getId()).setAvailable(true);
		em.remove(em.merge(r));
	}
}
