package com.tnsif.programs.superkey;

public class Super1 {
	int a = 10;
	public void display()
	{
		System.out.println("this is parent");
	}
}
class Super2 extends Super1{
	int a=20;
	
	public void display()
	{
		System.out.println("this is child");
		super.display();
		System.out.println(a); //20
		System.out.println(super.a); //10
	}

}
