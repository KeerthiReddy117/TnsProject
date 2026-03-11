package com.tnsif.programs.arrays;

public class MultiArryDemo {
	public static void main(String[] args) {
		
		int[][] num = new int[3][4];
		/*num[0][0]=3;
		num[1][1]=3;
		num[2][2]=3; */
		
		for(int i=0;i<3;i++)  //row
		{
			for(int j=0;j<4;j++)
			{
				num[i][j] = (int)(Math.random()*10);
			}
		}
		
		for(int i=0;i<3;i++)  //row
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(num[i][j] +" ");
			}
			System.out.println();  //new line
		}
		

	}

}
