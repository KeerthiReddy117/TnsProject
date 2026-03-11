package com.tnsif.programs.abstraction;

public abstract class Shape {
int area;
	
	abstract int calArea();  //abstract method
	
	public int show() {
		return area;
	}

}
