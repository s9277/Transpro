package com.transpro.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.transpro.domain.Car;
import com.transpro.domain.Driver;
import com.transpro.domain.Route;
import com.transpro.service.CarManager;
import com.transpro.service.DriverManager;
import com.transpro.service.RouteManager;

@SessionScoped
@Named("routeBean")
public class RouteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DriverManager dm = new DriverManager() ;
	
	@Inject
	private CarManager cm = new CarManager();
	
	@Inject
	private RouteManager rm = new RouteManager(); 
	
	private Route route = new Route();
	private Long driverId;
	private Long carId;
	
	private ListDataModel<Route> routes = new ListDataModel<Route>();
	
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
 
	public List<Driver> getAvailableDrivers(){
		
		return rm.getAvailableDrivers();
	}
	
	public List<Car> getAvailableCars(){
		return rm.getAvailableCars();
	}
	
	
	public ListDataModel<Route> getRoutes() {
		routes.setWrappedData(rm.getRoutes());
		return routes;
	}

	public void setRoutes(ListDataModel<Route> routes) {
		this.routes = routes;
	}

	public String createRoute(){
	
		rm.createRoute(driverId, carId, route );
		return "showRoutes";
	}
	
	public String addRoute(){
		
		return "showRoutes";
	}
	
	public void deleteRoute(){
		Route routeToDelete = routes.getRowData();
		rm.deleteRoute(routeToDelete);
		
	}

}
