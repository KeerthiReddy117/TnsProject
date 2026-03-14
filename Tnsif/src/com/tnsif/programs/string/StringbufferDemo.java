package com.tnsif.programs.string;

public class StringbufferDemo {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Welcome!");
		System.out.println(sb);
		System.out.println(sb.substring(3));
		System.out.println(sb.substring(3, 7));
		System.out.println(sb.replace(0, 7, "TNS"));
		System.out.println(sb.length()); //8
		System.out.println(sb.charAt(3)); //c
		System.out.println(sb.reverse());  //!emoclew
		System.out.println(sb);  //mutable in nature
		System.out.println(sb.substring(1));
		

	

	}

}
