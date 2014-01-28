package com.transpro.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "car")
@NamedQueries({
	@NamedQuery(name = "cars.all", query = "Select c from Car c"),
	@NamedQuery(name = "cars.available", query = "Select c from Car c where c.available = 1")
})
public class Car {
	
	private Long id;
	private String mark;
	private String type;
	private String regNr;
	private double fuelUsagePerKm;
	private Boolean Available = true;
	
	
	
	//-------------Constructors
	
	
	
	public Car(Long id, String mark, String type, String regNr,
			double fuelUsagePerKm, boolean isAvailable) {
		super();
		this.id = id;
		this.mark = mark;
		this.type = type;
		this.regNr = regNr;
		this.fuelUsagePerKm = fuelUsagePerKm;
		
	}
	
	
	
	
	public Car(String mark, String type, String regNr) {
		super();
		this.mark = mark;
		this.type = type;
		this.regNr = regNr;
	}
	
	
	
	public Car() {
		
	}

//----------------------------------
	
	

@Id
@Column(name = "idCar", unique = true)
@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "mark")
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Column(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "registrationNr")
	public String getRegNr() {
		return regNr;
	}
	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}
	
	@Column(name = "fuelUsageperKm")
	public double getFuelUsagePerKm() {
		return fuelUsagePerKm;
	}
	public void setFuelUsagePerKm(double fuelUsagePerKm) {
		this.fuelUsagePerKm = fuelUsagePerKm;
	}



	@Column(name = "available")
	public Boolean getAvailable() {
		return Available;
	}




	public void setAvailable(Boolean available) {
		Available = available;
	}




	

	
	

}
