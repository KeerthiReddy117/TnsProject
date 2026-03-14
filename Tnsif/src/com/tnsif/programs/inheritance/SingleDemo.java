package com.tnsif.programs.inheritance;

public class SingleDemo extends Single {
	String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void show()
	{
		System.out.println("name: "+getName()+ "salary :"+getSalary() +"city :"+getCity()+" country:"+country+"id :"+id);
	}
}
