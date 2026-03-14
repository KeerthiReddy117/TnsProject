package com.tnsif.programs.string;

public class StringDemo {

	public static void main(String[] args) {
		String s1 = "Hello";
		System.out.println(s1);
		String s2 = new String("Java");
		System.out.println(s2);
		
		System.out.println(s1.charAt(4));  //l  H-0,e-1,l-2,l=3,0-4
		System.out.println(s1.toUpperCase());  //HELLO - Hello
		System.out.println(s1); 
		System.out.println(s1.toLowerCase());  //hello
		System.out.println(s1);
		
		System.out.println(s1.compareTo(s2));  //Hello-Java
		System.out.println(s1.concat(" TNS"));  //Hello TNS
		System.out.println(s1);
		
		System.out.println(s1.equals(s2));
		
		String s3 = "Hello";
		System.out.println(s1.equals(s3));
		String s4 = new String("Hello");
		System.out.println(s1.equals(s4));  // true
		
		System.out.println(s1==s4);  //false
		System.out.println(s1.length());
		
	
	}

}
