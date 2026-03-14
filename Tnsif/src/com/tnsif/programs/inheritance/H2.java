package com.tnsif.programs.inheritance;

public class H2   extends Hparent{

	public void H2method()
	{
		System.out.println("This is H2 class");
	}
	
	public void show()
	{
		int a=30;
		System.out.println("the value of a is "+a);
		super.show();
	}
	
}
