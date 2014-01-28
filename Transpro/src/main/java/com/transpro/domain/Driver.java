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
@Table(name = "driver")
@NamedQueries({ 
    @NamedQuery(name = "drivers.all", query = "Select d from Driver d"),
  @NamedQuery(name = "drivers.available", query = "Select d from Driver d where d.available = 1")
})

public class Driver {
	
	private Long id;
	private String name;
	private String  surname;
	private double salary;
	private Boolean Available = true;
	
	


	//--------------Constructors
	
	public Driver(Long id, String name, String surname, double salary,
			boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		
	}
	
	
	public Driver(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	


	public Driver(Long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	
	


	public Driver() {
		
	}
	
	//--------------------------
	
	
	
	@Id
	@Column(name = "idDriver", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "surname")
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Transient
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	


	@Column(name = "available")
	public Boolean getAvailable() {
		return Available;
	}


	public void setAvailable(Boolean available) {
		Available = available;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
