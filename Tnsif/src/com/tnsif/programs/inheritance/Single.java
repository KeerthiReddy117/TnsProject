package com.tnsif.programs.inheritance;

public class Single {
	String name;
	int salary ;
	String city;
	
	int id=101;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Single [name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
	

}
