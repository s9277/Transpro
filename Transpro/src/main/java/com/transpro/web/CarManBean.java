package com.transpro.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.transpro.domain.Car;
import com.transpro.service.CarManager;


@SessionScoped
@Named("carManBean")
public class CarManBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Car car = new Car();
	
	private ListDataModel<Car> cars = new ListDataModel<Car>();
	
	@Inject
	private CarManager cm = new CarManager();

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public ListDataModel<Car> getCars() {
		cars.setWrappedData(cm.getAllCars());
		return cars;
	}

	public void setCars(ListDataModel<Car> cars) {
		this.cars = cars;
	}
	
	public String addCar(){
		
		cm.addCar(car);
		return "showCars";
		
	}
	
	 public String deleteCar() {
         Car carToDelete = cars.getRowData();
         cm.deleteCar(carToDelete);
         return null;
 }
	

}
