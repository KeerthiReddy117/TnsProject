package com.tnsif.programs.accessmodifiers.first;

public class sameclass {

	int defvari = 10;  
	private int privari = 20;   
	protected int protvari = 30;
	public int pubvari=40;
	
	public void defaultmethod()
	{
		System.out.println("the default value is: "+defvari);
	}
	public void privatemethod()
	{
		System.out.println("the private value is: "+privari);
	}
	public void protmethod()
	{
		System.out.println("the protected value is: "+protvari);
	}
	public void publicmethod()
	{
		System.out.println("the public value is: "+pubvari);
	}

}
