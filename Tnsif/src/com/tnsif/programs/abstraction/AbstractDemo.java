package com.tnsif.programs.abstraction;

public class AbstractDemo {

	public static void main(String[] args) {
		Square sq = new Square(4);
		sq.calArea();
		System.out.println(sq.show());
		
		
		rectangle r = new rectangle(2,3);
		r.calArea();
		System.out.println(r.show());

	}

}
