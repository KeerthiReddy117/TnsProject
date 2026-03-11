package com.tnsif.programs.abstraction;

public class rectangle extends Shape {
	int height;
	int width;
	
	
	public rectangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}


	@Override
	int calArea() {
		return area = height*width;	
	}
	
}
