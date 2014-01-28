package com.transpro.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "route")
@NamedQueries({ 
    @NamedQuery(name = "routes.all", query = "Select r from Route r")
})


public class Route {
	
	private Long id;
	private String source;
	private String destination;
	private String currentLocation;
	private Car car;
	private Driver driver;
	private List<Driver> drivers;
	

	//-----------------------------------------------
	
	public Route(Long id, String source, String destination,
			String currentLocation, Car car, List<Driver> drivers) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.currentLocation = currentLocation;
		this.car = car;
		this.drivers = drivers;
	}
	
	
	
	
	public Route(String source, String destination, Car car,
			List<Driver> drivers) {
		super();
		this.source = source;
		this.destination = destination;
		this.car = car;
		this.drivers = drivers;
	}
	


	public Route() {
	}

	public Route(String source, String destination, String currentLocation,
			Car car, Driver driver) {
		super();
		this.source = source;
		this.destination = destination;
		this.currentLocation = currentLocation;
		this.car = car;
		this.driver = driver;
	}

	



	public Route(String source, String destination, Car car, Driver driver) {
		super();
		this.source = source;
		this.destination = destination;
		this.car = car;
		this.driver = driver;
	}



	//-------------------------------------------
	
	



	@Id
	@Column(name = "IdRoute" ,unique = true) 
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "Source")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name = "Destination")
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Column(name = "CurrentLocation")
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	@Transient
	public List<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}



	@OneToOne(fetch =  FetchType.EAGER)
	public Driver getDriver() {
		return driver;
	}




	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	

}
