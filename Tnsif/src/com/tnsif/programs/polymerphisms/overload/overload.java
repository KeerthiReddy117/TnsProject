package com.tnsif.programs.polymerphisms.overload;

public class overload {
	overload()
	{
		
	}
	overload(int a)
	{
		
	}

	public void addition(int a)  
	{
		System.out.println("This is a :"+a);
	}
	public void addition(int a,int b)  
	{
		int c = a+b;
		System.out.println("The sum of a and b is :"+c);
	}
	public void addition(float x,double y,boolean n)  
	{
		System.out.println("The float value is :"+x+ " the double value is: "+y+" the boolean value is :"+n);
	}

}
