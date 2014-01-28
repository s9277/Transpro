package com.transpro.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.transpro.domain.Driver;
import com.transpro.service.DriverManager;


@SessionScoped
@Named("driverManBean")
public class DriverManBean implements Serializable{
	
	

	private static final long serialVersionUID = 1L;

	private Driver driver  = new Driver();
	
	private ListDataModel<Driver> drivers = new ListDataModel<Driver>();
	
	
	@Inject
	private DriverManager dm = new DriverManager();
	
	
	
	
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public ListDataModel<Driver> getDrivers() {
		drivers.setWrappedData(dm.getAllDrivers());
		return drivers;
	}

	public void setDrivers(ListDataModel<Driver> drivers) {
		this.drivers = drivers;
	}

	public DriverManager getDm() {
		return dm;
	}

	public void setDm(DriverManager dm) {
		this.dm = dm;
	}
	
	

	public String addDriver(){
		
		dm.addDriver(driver);
		
		return "showDrivers";
	}
	
	
	
	
	public void deleteDriver(){
		Driver driverToDelete = drivers.getRowData();
		dm.deleteDriver(driverToDelete);
		
	}

}
