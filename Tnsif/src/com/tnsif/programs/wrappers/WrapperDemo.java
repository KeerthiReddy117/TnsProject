package com.tnsif.programs.wrappers;

public class WrapperDemo {

	public static void main(String[] args) {
		int a = 10;
		System.out.println(a); //10
		Integer n = new Integer(a);  //converting PT to WC )Auto boxing
		System.out.println(n);  //10
		
		Long l = new Long(200); //l=200
		System.out.println(l);
		//long m = l; 
		long m = l.intValue(); //Auto Unboxing
		System.out.println(m);
		
	}


}
