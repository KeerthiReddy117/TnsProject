package com.tnsif.programs.thissuper;

public class ThisSample {
int a =10;
	
	public void show()
	{
		int a=20;  //if we don't declare a variable then the o/p is 20,20
		System.out.println("this is a"+a);  //20
		System.out.println("this is this.a"+this.a); //10
	}
}
