package com.tnsif.programs.abstraction;

public class Square extends Shape{
	int s;
	

	public Square(int s) {
		super();
		this.s = s;
	}


	int calArea() {
		return area = s*s;
	}
}
