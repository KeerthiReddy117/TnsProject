package com.tnsif.programs.construct;
import java.util.Scanner;


public class sampleDemo {

	public static void main(String[] args) {
		 sample ob = new sample();  //default/0 para con
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter std id");
			int id = sc.nextInt();
			Scanner sc1 = new Scanner(System.in);
			System.out.println("enter std name");
			String name = sc1.nextLine();
			System.out.println("enter std marks");
			int marks = sc.nextInt();
			
			
			System.out.println("id: "+id+" name:"+name+"marks: "+marks);

	}

}
