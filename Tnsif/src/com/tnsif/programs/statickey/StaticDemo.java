package com.tnsif.programs.statickey;
class Demo{
	static int a=10; //static variable
	
	static public void show()
	{
		System.out.println("this is static method");
	}
	static {
		System.out.println("this is static block");
	}
	
}


public class StaticDemo {
	public static void main(String[] args) {
		
		System.out.println(Demo.a);
		Demo.show();
	}

}
